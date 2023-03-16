package com.walid.gestion.de.stock.controller;


import com.walid.gestion.de.stock.controller.api.ArticleApi;
import com.walid.gestion.de.stock.dto.ArticleDto;
import com.walid.gestion.de.stock.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ArticleController implements ArticleApi {

    //Field Injection
    @Autowired
    private ArticleService articleService;



//    getter injection
    @Autowired
    public  ArticleService getArticleService(){

        return articleService;
    }


    @Autowired // spring dependency injection
//    constructor injection,
    public ArticleController(
            ArticleService articleService
    ) {
    this.articleService = articleService;

    }



    @Override
    public ArticleDto save(ArticleDto dto) {
        return null;
    }

    @Override
    public ArticleDto findById(Integer id) {
        return null;
    }

    @Override
    public ArticleDto findByCodeArticle(String codeArticle) {
        return null;
    }

    @Override
    public List<ArticleDto> findAll() {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }


//    @Autowired
//    @Qualifier("articleServiceImpl1")
//    private ArticleService articleService;



}
