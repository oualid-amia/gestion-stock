package com.walid.gestiondestock.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.walid.gestiondestock.model.Category;
import lombok.Builder;
import lombok.Data;

import java.util.List;


@Data
@Builder
public class CategoryDto {

    private Integer id;

    private String code;

    private String designation;


    @JsonIgnore
    private List<ArticleDto> articles;


    public static CategoryDto fromEntity(Category category) {

        if (category == null) {

            return null;
            // ttODO THROW AN EXCEPTION


        }

        return CategoryDto.builder()
                .id(category.getId())
                .code(category.getCode())
                .designation(category.getDesignation())
                .build();
    }

    public static Category toEntity(CategoryDto categorydto) {

        if (categorydto == null) {

            return null;
            // ttODO THROW AN EXCEPTION


        }


        Category category = new Category();
        category.setId(categorydto.getId());
        category.setCode(categorydto.getCode());
        category.setDesignation(categorydto.getDesignation());

        return category;

    }

}
