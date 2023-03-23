package com.walid.gestiondestock.services.implimentation;

import com.walid.gestiondestock.dto.CommandeFournisseurDto;
import com.walid.gestiondestock.dto.LigneCommandeFournisseurDto;
import com.walid.gestiondestock.exception.EntityNotFoundException;
import com.walid.gestiondestock.exception.ErrorCodes;
import com.walid.gestiondestock.exception.InvalidEntityException;
import com.walid.gestiondestock.model.*;
import com.walid.gestiondestock.repository.*;
import com.walid.gestiondestock.services.CommandeFournisseurService;
import com.walid.gestiondestock.validator.CommandeFournisseurValidator;
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
public class CommandeFournisseurServiceImpl implements CommandeFournisseurService {

    private CommandeFournisseurRepository commandeFournisseurRepository;

    private LigneCommandeFournisseurRepository ligneCommandeFournisseurRepository;

    private FournisseurRepository fournisseurRepository;

    private ArticleRepository articleRepository;

    @Autowired
    public CommandeFournisseurServiceImpl(CommandeFournisseurRepository commandeFournisseurRepository,
                                          FournisseurRepository fournisseurRepository, ArticleRepository articleRepository,
                                          LigneCommandeFournisseurRepository ligneCommandeFournisseurRepository) {
        this.commandeFournisseurRepository = commandeFournisseurRepository;
        this.ligneCommandeFournisseurRepository = ligneCommandeFournisseurRepository;
        this.fournisseurRepository = fournisseurRepository;
        this.articleRepository = articleRepository;
//        this.mvtStkService = mvtStkService;
    }

    @Override
    public CommandeFournisseurDto save(CommandeFournisseurDto dto) {


        List<String > errors = CommandeFournisseurValidator.Validate(dto);

        if (!errors.isEmpty()){

            log.error("Commande Fournisseur n'est pas valide ", dto);
            throw new InvalidEntityException("Commande Fournisseur n'est pas valide ", ErrorCodes.COMMANDE_FOURNISSEUR_NOT_VALIDE,errors);
        }
        Optional<Fournisseur> fournisseur = fournisseurRepository.findById(dto.getFournisseur().getId());
        if (fournisseur.isEmpty()){

            log.warn("Fournisseur with ID {} was not found in the DB",dto.getFournisseur().getId());
            throw new EntityNotFoundException("Aucun Fournisseur avec L'ID " + dto.getFournisseur().getId() + "n'a ete trouve dans la BDD",
                    ErrorCodes.FOURNISSEUR_NOT_FOUND);
        }

        List<String> articleErrors = new ArrayList<>();

        if (dto.getLigneCommandeFournisseurs() != null) {
            dto.getLigneCommandeFournisseurs().forEach(ligcmdf -> {
                if (ligcmdf.getArticle() != null) {
                    Optional<Article> article = articleRepository.findById(ligcmdf.getArticle().getId());
                    if (article.isEmpty()) {
                        articleErrors.add("l.article   l'ID " + ligcmdf.getArticle().getId() + " n'existe pas");
                    }
                }else {
                    articleErrors.add("Impossible d'enregistrer une commande avec un article null ");
                }
            });
        }

        if (! articleErrors.isEmpty()){

            log.warn("");
            throw new InvalidEntityException("Article n'existe pas dans la BDD", ErrorCodes.ARTICLE_NOT_FOUND, articleErrors );
        }

        CommandFournisseur savedCmdF  = commandeFournisseurRepository.save(CommandeFournisseurDto.toEntity(dto));

        if (dto.getLigneCommandeFournisseurs() != null) {
            dto.getLigneCommandeFournisseurs().forEach(ligCmdF -> {
                LigneCommandeFournisseur ligneCommandeFournisseur = LigneCommandeFournisseurDto.toEntity(ligCmdF);
                ligneCommandeFournisseur.setCommandefournisseur(savedCmdF);
//                ligneCommandeClient.setIdEntreprise(dto.getIdentreprise());
                LigneCommandeFournisseur savedLigneCmdF = ligneCommandeFournisseurRepository.save(ligneCommandeFournisseur);

//                effectuerSortie(savedLigneCmdF);
            });
        }

        return CommandeFournisseurDto.fromEntity(savedCmdF);
    }



    @Override
    public CommandeFournisseurDto findById(Integer id) {


        if(id == null){

            log.error("Commande client ID is null");
        }

        return commandeFournisseurRepository.findById(id)
                .map(CommandeFournisseurDto::fromEntity)
                .orElseThrow(()-> new EntityNotFoundException("Aucun Commande Fournisseur avec l'ID = " + id + " n'est trouve dans la BDD",
                        ErrorCodes.COMMANDE_FOURNISSEUR_NOT_FOUND));
    }

    @Override
    public CommandeFournisseurDto findByCode(String code) {

        if (!StringUtils.hasLength(code)){
            log.error("code commande Fournisseur est null");
            return null;

        }
        return commandeFournisseurRepository.findCommandeFournisseurByCode(code)
                .map(CommandeFournisseurDto::fromEntity)
                .orElseThrow(()-> new EntityNotFoundException(
                        "Aucun Commande Fournisseur avec le code = " + code + " n'est trouve dans la BDD",
                        ErrorCodes.COMMANDE_FOURNISSEUR_NOT_FOUND
                ));

//        Optional<CommandeClient> commandeClient = commandeClientRepository.findCommandeClientByCode(code);
//
//        return Optional.of(CommandeClientDto.fromEntity(commandeClient.get())).orElseThrow(()->
//                new EntityNotFoundException(
//                        "Aucun article avec le code  = " + code + " n'est trouve dans la BDD",
//                        ErrorCodes.COMMANDE_CLIENT_NOT_FOUND)
//        );

    }

    @Override
    public List<CommandeFournisseurDto> findAll() {


        return commandeFournisseurRepository.findAll().stream()
                .map(CommandeFournisseurDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {

        if (id == null){

            log.error("Commande Client Id is Null");
        }

        commandeFournisseurRepository.deleteById(id);

    }

//    private void effectuerSortie(LigneCommandeClient lig) {
//        MvtStkDto mvtStkDto = MvtStkDto.builder()
//                .article(ArticleDto.fromEntity(lig.getArticle()))
//                .datemvt(Instant.now())
//                .typeMvt(TypeMvtStk.SORTIE)
//                .sourceMvt(SourceMvtStk.COMMANDE_CLIENT)
//                .quantite(lig.getQuantite())
//                .idEntreprise(lig.getIdEntreprise())
//                .build();
//        mvtStkService.sortieStock(mvtStkDto);
//    }
}