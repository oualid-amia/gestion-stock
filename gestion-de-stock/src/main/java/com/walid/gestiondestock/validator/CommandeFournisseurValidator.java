package com.walid.gestiondestock.validator;

import com.walid.gestiondestock.dto.CommandeClientDto;
import com.walid.gestiondestock.dto.CommandeFournisseurDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class CommandeFournisseurValidator {



    public static List<String> Validate(CommandeFournisseurDto commandeFournisseurDto){

        List<String> errors = new ArrayList<>();

        if (commandeFournisseurDto == null){

            errors.add("Veuillez renseigner le code de la Commande fournisseur");
            errors.add("Veuillez renseigner la date de la Commande fournisseur");
            errors.add("Veuillez renseigner le fournisseur");

            return errors;

        }


        if (!StringUtils.hasLength((commandeFournisseurDto.getCode()))){

            errors.add("Veuillez renseigner le code de la commande fournisseur");

        }

        if (commandeFournisseurDto.getDateCommande() == null){

            errors.add("Veuillez renseigner la date de commande fournisseur");

        }

        if (commandeFournisseurDto.getFournisseur() == null || commandeFournisseurDto.getFournisseur().getId() == null) {
            errors.add("Veuillez renseigner le fournisseur");
        }


        return  errors;
    }
}
