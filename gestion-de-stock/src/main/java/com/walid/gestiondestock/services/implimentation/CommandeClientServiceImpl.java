package com.walid.gestiondestock.services.implimentation;

import com.walid.gestiondestock.dto.*;
import com.walid.gestiondestock.exception.EntityNotFoundException;
import com.walid.gestiondestock.exception.ErrorCodes;
import com.walid.gestiondestock.exception.InvalidEntityException;
import com.walid.gestiondestock.model.*;
import com.walid.gestiondestock.repository.ArticleRepository;
import com.walid.gestiondestock.repository.ClientRepository;
import com.walid.gestiondestock.repository.CommandeClientRepository;
import com.walid.gestiondestock.repository.LigneCommandeClientRepository;
import com.walid.gestiondestock.services.CommandeClientService;
import com.walid.gestiondestock.validator.CommandeClientValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CommandeClientServiceImpl implements CommandeClientService {


    private CommandeClientRepository commandeClientRepository;

    private LigneCommandeClientRepository ligneCommandeClientRepository;
    private ClientRepository clientRepository;
    private ArticleRepository articleRepository;

//    private MvtStkService mvtStkService;


    @Autowired
    public CommandeClientServiceImpl(CommandeClientRepository commandeClientRepository,
                                     ClientRepository clientRepository, ArticleRepository articleRepository, LigneCommandeClientRepository ligneCommandeClientRepository) {
        this.commandeClientRepository = commandeClientRepository;
        this.ligneCommandeClientRepository = ligneCommandeClientRepository;
        this.clientRepository = clientRepository;
        this.articleRepository = articleRepository;
//        this.mvtStkService = mvtStkService;
    }

    @Override
    public CommandeClientDto save(CommandeClientDto dto) {


        List<String > errors = CommandeClientValidator.Validate(dto);

        if (!errors.isEmpty()){

            log.error("Commande Client n'est pas valide ", dto);
            throw new InvalidEntityException("Commande Client n'est pas valide ", ErrorCodes.COMMANDE_CLIENT_NOT_VALIDE,errors);
        }
        Optional<Client> client = clientRepository.findById(dto.getClient().getId());
        if (client.isEmpty()){

            log.warn("Client with ID {} was not found in the DB",dto.getClient().getId());
            throw new EntityNotFoundException("Aucun client avec L'ID " + dto.getClient().getId() + "n'a ete trouve dans la BDD",
                    ErrorCodes.CLIENT_NOT_FOUND);
        }

        List<String> articleErrors = new ArrayList<>();

        if (dto.getLigneCommadeclients() != null) {
            dto.getLigneCommadeclients().forEach(ligcmdclt -> {
                if (ligcmdclt.getArticle() != null) {
                    Optional<Article> article = articleRepository.findById(ligcmdclt.getArticle().getId());
                    if (article.isEmpty()) {
                        articleErrors.add("l'article avec l'ID " + ligcmdclt.getArticle().getId() + " n'existe pas");
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

        CommandeClient savedCmdClt  = commandeClientRepository.save(CommandeClientDto.toEntity(dto));

        if (dto.getLigneCommadeclients() != null) {
            dto.getLigneCommadeclients().forEach(ligCmdClt -> {
                LigneCommandeClient ligneCommandeClient = LigneCommandeClientDto.toEntity(ligCmdClt);
                ligneCommandeClient.setCommandeclient(savedCmdClt);
//                ligneCommandeClient.setIdEntreprise(dto.getIdentreprise());
                LigneCommandeClient savedLigneCmd = ligneCommandeClientRepository.save(ligneCommandeClient);

//                effectuerSortie(savedLigneCmd);
            });
        }

        return CommandeClientDto.fromEntity(savedCmdClt);
    }



    @Override
    public CommandeClientDto findById(Integer id) {


        if(id == null){

            log.error("Commande client ID is null");
        }

        return commandeClientRepository.findById(id)
                .map(CommandeClientDto::fromEntity)
                .orElseThrow(()-> new EntityNotFoundException("Aucun Commande Client avec l'ID = " + id + " n'est trouve dans la BDD",
                        ErrorCodes.COMMANDE_CLIENT_NOT_FOUND));
    }

    @Override
    public CommandeClientDto findByCode(String code) {

        if (!StringUtils.hasLength(code)){
            log.error("code commande client est null");
            return null;

        }
        return commandeClientRepository.findCommandeClientByCode(code)
                .map(CommandeClientDto::fromEntity)
                .orElseThrow(()-> new EntityNotFoundException(
                        "Aucun Commande client avec le code = " + code + " n'est trouve dans la BDD",
                        ErrorCodes.COMMANDE_CLIENT_NOT_FOUND
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
    public List<CommandeClientDto> findAll() {


        return commandeClientRepository.findAll().stream()
                .map(CommandeClientDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {

        if (id == null){

            log.error("Commande Client Id is Null");
        }

        commandeClientRepository.deleteById(id);

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
