package com.walid.gestion.de.stock.dto;



import com.fasterxml.jackson.annotation.JsonIgnore;
import com.walid.gestion.de.stock.model.Article;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;


@Data
@Builder

public class ArticleDto {



    private Integer id;

    private String codeArticle;

    private String designation;

    private BigDecimal prixUnitaireHt;

    private BigDecimal tauxTva;

    private BigDecimal prixUnitaireTtc;

    private String photo;


    @JsonIgnore
    private CategoryDto category;


    public static ArticleDto fromEntity(Article article) {

        if (article == null) {

            return null;
            // ttODO THROW AN EXCEPTION


        }

        return ArticleDto.builder()
                .id(article.getId())
                .codeArticle(article.getCodeArticle())
                .designation(article.getDesignation())
                .prixUnitaireHt(article.getPrixUnitaireHt())
                .tauxTva(article.getTauxTva())
                .prixUnitaireTtc(article.getPrixUnitaireTtc())
                .photo(article.getPhoto())
                .build();
    }

    public static Article toEntity(ArticleDto articleDto) {

        if (articleDto == null) {

            return null;
            // ttODO THROW AN EXCEPTION


        }


        Article article = new Article();
        article.setId(articleDto.getId());
        article.setCodeArticle(articleDto.getCodeArticle());
        article.setDesignation(articleDto.getDesignation());
        article.setPrixUnitaireHt(articleDto.getPrixUnitaireHt());
        article.setTauxTva(articleDto.getTauxTva());
        article.setPrixUnitaireTtc(articleDto.getPrixUnitaireTtc());
        article.setPhoto(articleDto.getPhoto());

        return article;

    }

}


