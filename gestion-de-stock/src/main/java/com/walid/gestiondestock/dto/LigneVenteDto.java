package com.walid.gestiondestock.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.walid.gestiondestock.model.LigneVente;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;


@Data
@Builder
public class LigneVenteDto {
    private Integer id;

//    @JsonIgnore
    private VentesDto ventes;



//    @JsonIgnore
    private ArticleDto article;

    private BigDecimal quantite;


    private BigDecimal prixunitaire;


    public static LigneVenteDto fromEntity(LigneVente ligneVente) {

        if (ligneVente == null) {

            return null;
            // ttODO THROW AN EXCEPTION


        }

        return LigneVenteDto.builder()
                .id(ligneVente.getId())
                .quantite(ligneVente.getQuantite())
                .prixunitaire(ligneVente.getPrixunitaire())

                .build();
    }

    public static LigneVente toEntity(LigneVenteDto ligneVenteDto) {

        if (ligneVenteDto == null) {

            return null;
            // ttODO THROW AN EXCEPTION


        }


        LigneVente ligneVente = new LigneVente();
        ligneVente.setId(ligneVenteDto.getId());
        ligneVente.setQuantite((ligneVenteDto.getQuantite()));
        ligneVente.setPrixunitaire(ligneVenteDto.getPrixunitaire());



        return ligneVente;

    }

}
