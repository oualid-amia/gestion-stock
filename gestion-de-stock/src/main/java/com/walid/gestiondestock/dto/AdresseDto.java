package com.walid.gestiondestock.dto;

import com.walid.gestiondestock.model.Adresse;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class AdresseDto {

    private String adresse1;

    private String adresse2;


    private String ville;


    private String codepostale;


    private String pays;


    public static AdresseDto fromEntity(Adresse adresse) {

        if (adresse == null) {

            return null;
            // ttODO THROW AN EXCEPTION


        }

        return AdresseDto.builder()
                .adresse1(adresse.getAdresse1())
                .adresse2(adresse.getAdresse2())
                .codepostale(adresse.getCodepostale())
                .ville(adresse.getVille())
                .pays(adresse.getPays())
                .build();
    }

    public static Adresse toEntity(AdresseDto adresseDto) {

        if (adresseDto == null) {

            return null;
            // ttODO THROW AN EXCEPTION


        }


        Adresse adresse = new Adresse();
        adresse.setAdresse1(adresseDto.getAdresse1());
        adresse.setAdresse2(adresseDto.getAdresse2());
        adresse.setCodepostale(adresseDto.getCodepostale());
        adresse.setVille(adresseDto.getVille());
        adresse.setPays(adresseDto.getPays());

        return adresse;

    }





}
