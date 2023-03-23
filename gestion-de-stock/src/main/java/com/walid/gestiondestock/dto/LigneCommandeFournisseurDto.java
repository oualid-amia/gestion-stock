package com.walid.gestiondestock.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.walid.gestiondestock.model.LigneCommandeFournisseur;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class LigneCommandeFournisseurDto {
    private Integer id;


    private ArticleDto article;



    @JsonIgnore
    private CommandeFournisseurDto commandeFournisseurDto;

    private BigDecimal quantite;


    private BigDecimal prixunitaire;

    public static LigneCommandeFournisseurDto fromEntity(LigneCommandeFournisseur ligneCommandeFournisseur) {

        if (ligneCommandeFournisseur == null) {

            return null;
            // ttODO THROW AN EXCEPTION


        }

        return LigneCommandeFournisseurDto.builder()
                .id(ligneCommandeFournisseur.getId())
                .quantite(ligneCommandeFournisseur.getQuantite())
                .prixunitaire(ligneCommandeFournisseur.getPrixunitaire())

                .build();
    }

    public static LigneCommandeFournisseur toEntity(LigneCommandeFournisseurDto ligneCommandeFournisseurDto) {

        if (ligneCommandeFournisseurDto == null) {

            return null;
            // ttODO THROW AN EXCEPTION


        }


        LigneCommandeFournisseur ligneCommandeFournisseur = new LigneCommandeFournisseur();
        ligneCommandeFournisseur.setId(ligneCommandeFournisseurDto.getId());
        ligneCommandeFournisseur.setQuantite((ligneCommandeFournisseurDto.getQuantite()));
        ligneCommandeFournisseur.setPrixunitaire(ligneCommandeFournisseurDto.getPrixunitaire());



        return ligneCommandeFournisseur;

    }
}
