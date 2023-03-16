package com.walid.gestion.de.stock.validator;

import com.walid.gestion.de.stock.dto.CommandeClientDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class CommandeClientValidator {


    public static List<String> Validate(CommandeClientDto commandeClientDto){

        List<String> errors = new ArrayList<>();

        if (commandeClientDto == null){

            errors.add("Veuillez renseigner le code de l'article");
            errors.add("Veuillez renseigner la date de commande client");

            return errors;

        }


        if (!StringUtils.hasLength((commandeClientDto.getCode()))){

            errors.add("Veuillez renseigner le code de la commande client");

        }

        if (commandeClientDto.getDateCommande() == null){

            errors.add("Veuillez renseigner la date de commande client");

        }




        return  errors;
    }
}
