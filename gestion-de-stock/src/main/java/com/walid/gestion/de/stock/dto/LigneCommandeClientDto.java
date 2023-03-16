package com.walid.gestion.de.stock.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.walid.gestion.de.stock.model.LigneCommandeClient;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class LigneCommandeClientDto {
    private Integer id;

    @JsonIgnore
    private ArticleDto article;


    @JsonIgnore
    private CommandeClientDto commendeclient;

    private BigDecimal quantite;


    private BigDecimal prixunitaire;


    public LigneCommandeClientDto fromEntity(LigneCommandeClient ligneCommandeClient) {

        if (ligneCommandeClient == null) {

            return null;
            // ttODO THROW AN EXCEPTION


        }

        return LigneCommandeClientDto.builder()
                .id(ligneCommandeClient.getId())
                .quantite(ligneCommandeClient.getQuantite())
                .prixunitaire(ligneCommandeClient.getPrixunitaire())

                .build();
    }

    public LigneCommandeClient toEntity(LigneCommandeClientDto ligneCommandeClientDto) {

        if (ligneCommandeClientDto == null) {

            return null;
            // ttODO THROW AN EXCEPTION


        }


        LigneCommandeClient ligneCommandeClient = new LigneCommandeClient();
        ligneCommandeClient.setId(ligneCommandeClientDto.getId());
        ligneCommandeClient.setQuantite((ligneCommandeClientDto.getQuantite()));
        ligneCommandeClient.setPrixunitaire(ligneCommandeClientDto.getPrixunitaire());



        return ligneCommandeClient;

    }

}
