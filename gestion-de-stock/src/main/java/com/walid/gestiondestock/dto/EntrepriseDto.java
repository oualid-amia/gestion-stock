package com.walid.gestiondestock.dto;



import com.fasterxml.jackson.annotation.JsonIgnore;
import com.walid.gestiondestock.model.Entreprise;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder

public class EntrepriseDto {

    private Integer id;

    private String nom;

    private String description;


    @JsonIgnore
    private AdresseDto adresse;

    private String codeFiscla;

    private String photo;

    private String email;

    private String numtel;

    private String steweb;
    @JsonIgnore
    private List<UtilisateurDto> utilisateurs;


    public static EntrepriseDto fromEntity(Entreprise entreprise) {

        if (entreprise == null) {

            return null;
            // ttODO THROW AN EXCEPTION


        }

        return EntrepriseDto.builder()
                .id(entreprise.getId())
                .nom(entreprise.getNom())
                .photo(entreprise.getPhoto())
                .email(entreprise.getEmail())
                .numtel(entreprise.getNumtel())
                .steweb(entreprise.getSteweb())
                .description(entreprise.getDescription())
                .codeFiscla(entreprise.getCodeFiscla())

                .build();
    }

    public static Entreprise toEntity(EntrepriseDto entrepriseDto) {

        if (entrepriseDto == null) {

            return null;
            // ttODO THROW AN EXCEPTION


        }


        Entreprise entreprise = new Entreprise();
        entreprise.setId(entrepriseDto.getId());
        entreprise.setNom(entrepriseDto.getNom());
        entreprise.setPhoto(entrepriseDto.getPhoto());
        entreprise.setEmail(entrepriseDto.getEmail());
        entreprise.setNumtel(entrepriseDto.getNumtel());
        entreprise.setSteweb(entrepriseDto.getSteweb());
        entreprise.setDescription(entrepriseDto.getDescription());
        entreprise.setCodeFiscla(entrepriseDto.getCodeFiscla());

        return entreprise;

    }




}
