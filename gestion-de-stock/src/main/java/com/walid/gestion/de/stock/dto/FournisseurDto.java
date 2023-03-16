package com.walid.gestion.de.stock.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.walid.gestion.de.stock.model.Fournisseur;
import jakarta.persistence.Embedded;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder

public class FournisseurDto {

    private Integer id;

    private String nom;

    private String prenom;

    @Embedded
    private AdresseDto adresse;

    private String photo;

    private String mail;

    private String numtel;

    @JsonIgnore
    private List<CommandeFournisseurDto> commandFournisseurs;


    public FournisseurDto fromEntity(Fournisseur fournisseur) {

        if (fournisseur == null) {

            return null;
            // ttODO THROW AN EXCEPTION


        }

        return FournisseurDto.builder()
                .id(fournisseur.getId())
                .nom(fournisseur.getNom())
                .prenom(fournisseur.getPrenom())
                .photo(fournisseur.getPhoto())
                .mail(fournisseur.getMail())
                .numtel(fournisseur.getNumtel())
                .build();
    }

    public Fournisseur toEntity(FournisseurDto fournisseurDto) {

        if (fournisseurDto == null) {

            return null;
            // ttODO THROW AN EXCEPTION


        }


        Fournisseur fournisseur = new Fournisseur();
        fournisseur.setId(fournisseurDto.getId());
        fournisseur.setNom(fournisseurDto.getNom());
        fournisseur.setPrenom(fournisseurDto.getPrenom());
        fournisseur.setPhoto(fournisseurDto.getPhoto());
        fournisseur.setMail(fournisseurDto.getMail());
        fournisseur.setNumtel(fournisseurDto.getNumtel());

        return fournisseur;

    }

}
