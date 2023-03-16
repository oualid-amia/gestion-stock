package com.walid.gestion.de.stock.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.walid.gestion.de.stock.model.Utilisateur;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.util.List;


@Data
@Builder
public class UtilisateurDto {


    private Integer id;

    private String nom;

    private String prenom;

    private String email;

    private String datedenaissance;

    private String motdepasse;

    private String photo;

    @Embedded
    private AdresseDto adresse;




    @JsonIgnore
    private EntrepriseDto entreprise;


    @JsonIgnore
    private List<RolesDto> roles;


    public UtilisateurDto fromEntity(Utilisateur utilisateur) {

        if (utilisateur == null) {

            return null;
            // ttODO THROW AN EXCEPTION


        }

        return UtilisateurDto.builder()
                .id(utilisateur.getId())
                .nom(utilisateur.getNom())
                .prenom(utilisateur.getPrenom())
                .email(utilisateur.getEmail())
                .datedenaissance(utilisateur.getDatedenaissance())
                .motdepasse(utilisateur.getMotdepasse())
                .photo(utilisateur.getPhoto())

                .build();
    }

    public Utilisateur toEntity(UtilisateurDto utilisateurDto) {

        if (utilisateurDto == null) {

            return null;
            // ttODO THROW AN EXCEPTION


        }


        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setId(utilisateurDto.getId());
        utilisateur.setNom(utilisateurDto.getNom());
        utilisateur.setPrenom(utilisateurDto.getPrenom());
        utilisateur.setDatedenaissance(utilisateurDto.getDatedenaissance());
        utilisateur.setMotdepasse(utilisateurDto.getMotdepasse());
        utilisateur.setEmail(utilisateurDto.getEmail());
        utilisateur.setPhoto(utilisateurDto.getPhoto());


        return utilisateur;

    }


}
