package com.walid.gestiondestock.controller;


import com.walid.gestiondestock.controller.api.ArticleApi;
import com.walid.gestiondestock.dto.ArticleDto;
import com.walid.gestiondestock.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ArticleController implements ArticleApi {

    private ArticleService articleService;



    @Autowired // spring dependency injection
//    constructor injection,
    public ArticleController(
            ArticleService articleService
    ) {
    this.articleService = articleService;

    }



    @Override
    public ArticleDto save(ArticleDto dto) {
        return articleService.save(dto);
    }

    @Override
    public ArticleDto findById(Integer id) {
        return articleService.findById(id);
    }

    @Override
    public ArticleDto findByCodeArticle(String codeArticle) {
        return articleService.findByCodeArticle(codeArticle);
    }

    @Override
    public List<ArticleDto> findAll() {
        return articleService.findAll();
    }

    @Override
    public void delete(Integer id) {
        articleService.delete(id);

    }





}
