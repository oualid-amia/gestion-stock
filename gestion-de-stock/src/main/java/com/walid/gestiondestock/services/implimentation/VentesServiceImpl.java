package com.walid.gestiondestock.services.implimentation;

import com.walid.gestiondestock.dto.CommandeFournisseurDto;
import com.walid.gestiondestock.dto.LigneVenteDto;
import com.walid.gestiondestock.dto.VentesDto;
import com.walid.gestiondestock.exception.EntityNotFoundException;
import com.walid.gestiondestock.exception.ErrorCodes;
import com.walid.gestiondestock.exception.InvalidEntityException;
import com.walid.gestiondestock.model.Article;
import com.walid.gestiondestock.model.LigneVente;
import com.walid.gestiondestock.model.Ventes;
import com.walid.gestiondestock.repository.ArticleRepository;
import com.walid.gestiondestock.repository.LigneVentesRepository;
import com.walid.gestiondestock.repository.VentesRepository;
import com.walid.gestiondestock.services.VentesService;
import com.walid.gestiondestock.validator.VentesValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@Slf4j
public class VentesServiceImpl implements VentesService {

    private VentesRepository ventesRepository;
    private ArticleRepository articleRepository;
    private LigneVentesRepository ligneVentesRepository;


    @Autowired
    public VentesServiceImpl(VentesRepository ventesRepository, ArticleRepository articleRepository, LigneVentesRepository ligneVentesRepository) {
        this.ventesRepository = ventesRepository;
        this.articleRepository = articleRepository;
        this.ligneVentesRepository = ligneVentesRepository;
    }


    @Override
    public VentesDto save(VentesDto dto) {
        List<String> errors = VentesValidator.Validate(dto);
        if (!errors.isEmpty()) {
            log.error("Ventes n'est pas valide");
            throw new InvalidEntityException("L'objet vente n'est pas valide", ErrorCodes.VENTES_NOT_VALIDE, errors);
        }
        List<String> articleErrors = new ArrayList<>();
        dto.getLigneVentes().forEach(ligneVenteDto -> {
            Optional<Article> article = articleRepository.findById(ligneVenteDto.getArticle().getId());
            if (article.isEmpty()) {
                articleErrors.add("Aucun article avec l'ID " + ligneVenteDto.getArticle().getId() + " n'a ete trouve dans la BDD");
            }
        });
        if (!articleErrors.isEmpty()) {
            log.error("One or more articles were not found in the DB, {}", errors);
            throw new InvalidEntityException("Un ou plusieurs articles n'ont pas ete trouve dans la BDD", ErrorCodes.VENTES_NOT_VALIDE, errors);
        }
        Ventes savedVentes = ventesRepository.save(VentesDto.toEntity(dto));
        dto.getLigneVentes().forEach(ligneVenteDto -> {
            LigneVente ligneVente = LigneVenteDto.toEntity(ligneVenteDto);
            ligneVente.setVentes(savedVentes);
            ligneVentesRepository.save(ligneVente);
//            updateMvtStk(ligneVente);
        });
        return VentesDto.fromEntity(savedVentes);
    }

    @Override
    public VentesDto findById(Integer id) {
        if(id == null){

            log.error("Ventes ID is null");
        }

        return ventesRepository.findById(id)
                .map(VentesDto::fromEntity)
                .orElseThrow(()-> new EntityNotFoundException("Aucune Vente avec l'ID = " + id + " n'est trouve dans la BDD",
                        ErrorCodes.VENTES_NOT_FOUND));
    }


    @Override
    public VentesDto findByCode(String code) {
        if (!StringUtils.hasLength(code)) {
            log.error("Vente CODE is NULL");
            return null;
        }
        return ventesRepository.findVentesByCode(code)
                .map(VentesDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Aucune vente client n'a ete trouve avec le CODE " + code, ErrorCodes.VENTES_NOT_VALIDE
                ));
    }

    @Override
    public List<VentesDto> findAll() {
        return ventesRepository.findAll().stream()
                .map(VentesDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {

        if (id == null){

            log.error("Vente Id is Null");
        }

        ventesRepository.deleteById(id);

    }
}
