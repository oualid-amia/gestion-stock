package com.walid.gestiondestock.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.walid.gestiondestock.model.LigneCommandeClient;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class LigneCommandeClientDto {




    private Integer id;

    private ArticleDto article;

    @JsonIgnore
    private CommandeClientDto commandeclient;

    private BigDecimal quantite;

    private BigDecimal prixunitaire;

    private Integer idEntreprise;







    public static  LigneCommandeClientDto fromEntity(LigneCommandeClient ligneCommandeClient) {

        if (ligneCommandeClient == null) {

            return null;
            // ttODO THROW AN EXCEPTION


        }

        return LigneCommandeClientDto.builder()
                .id(ligneCommandeClient.getId())
                .article(ArticleDto.fromEntity(ligneCommandeClient.getArticle()))
                .quantite(ligneCommandeClient.getQuantite())
                .prixunitaire(ligneCommandeClient.getPrixunitaire())
                .idEntreprise(ligneCommandeClient.getIdEntreprise())

                .build();
    }

    public static LigneCommandeClient toEntity(LigneCommandeClientDto ligneCommandeClientDto) {

        if (ligneCommandeClientDto == null) {

            return null;
            // ttODO THROW AN EXCEPTION


        }


        LigneCommandeClient ligneCommandeClient = new LigneCommandeClient();
        ligneCommandeClient.setId(ligneCommandeClientDto.getId());
        ligneCommandeClient.setArticle(ArticleDto.toEntity(ligneCommandeClientDto.getArticle()));
        ligneCommandeClient.setQuantite((ligneCommandeClientDto.getQuantite()));
        ligneCommandeClient.setPrixunitaire(ligneCommandeClientDto.getPrixunitaire());
        ligneCommandeClient.setIdEntreprise(ligneCommandeClientDto.getIdEntreprise());



        return ligneCommandeClient;

    }

}
