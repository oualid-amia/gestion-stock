package com.walid.gestion.de.stock.validator;

import com.walid.gestion.de.stock.dto.ArticleDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ArticleValidator {

    public static List<String> Validate(ArticleDto articleDto){

        List<String> errors = new ArrayList<>();

        if (articleDto == null){

            errors.add("Veuillez renseigner le code de l'article");
            errors.add("Veuillez renseigner la designation de l'article");
            errors.add("Veuillez renseigner la prix unitaire HT de l'article");
            errors.add("Veuillez renseigner LE TAUX tva de l'article");
            errors.add("Veuillez renseigner la prix unitaire TTC de l'article");
            errors.add("Veuillez selectionner une categorie");
            return errors;

        }


        if (!StringUtils.hasLength((articleDto.getCodeArticle()))){

            errors.add("Veuillez renseigner le code de l'article");

        }

        if (!StringUtils.hasLength((articleDto.getDesignation()))){

            errors.add("Veuillez renseigner la designation de l'article");

        }

        if (articleDto.getPrixUnitaireHt() == null){

            errors.add("Veuillez renseigner la prix unitaire HT de l'article");
        }

        if (articleDto.getTauxTva() == null){

            errors.add("Veuillez renseigner LE TAUX tva de l'article");
        }


        if (articleDto.getPrixUnitaireTtc() == null){

            errors.add("Veuillez renseigner la prix unitaire TTC de l'article");
        }


        if (articleDto.getCategory() == null){

            errors.add("Veuillez selectionner une categorie");
        }





        return  errors;
    }
}
