package com.walid.gestiondestock.validator;

import com.walid.gestiondestock.dto.CategoryDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class CategoryValidator {


    public static List<String> Validate(CategoryDto categoryDto){

        List<String> errors = new ArrayList<>();




        if (categoryDto == null || !StringUtils.hasLength((categoryDto.getCode()))){

            errors.add("Veuillez renseigner le code de la category");


        }

        return  errors;
    }
}
