package com.walid.gestiondestock.controller.api;

import com.walid.gestiondestock.dto.ArticleDto;
import com.walid.gestiondestock.utils.Constants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.*;
import  org.springframework.http.MediaType;

import java.util.List;

import static com.walid.gestiondestock.utils.Constants.APP_ROOT;


//      http://localhost:8081/gestiondestock/v1/articles/create //
@Api(APP_ROOT + "/articles")
public interface ArticleApi {


    @PostMapping(value = APP_ROOT + "/articles/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Enregistrer un article", notes = "Cette methode permet d'enregistrer ou modifier un article", response = ArticleDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "l'objet article cree / modifie"),
            @ApiResponse(code = 400, message = "l'objet article n'est pas Valide")

    })
    ArticleDto save(@RequestBody ArticleDto dto);

    @GetMapping(value = APP_ROOT + "/articles/{idArticle}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Rechercher un article", notes = "Cette methode permet de chercher un article par son ID", response = ArticleDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "l'article a ete trouver dans la BDD"),
            @ApiResponse(code = 404, message = "Aucun Article n'existe dans la BDD avec l'ID fourni")
    })
    ArticleDto findById(@PathVariable("idArticle") Integer id);



    @GetMapping(value = APP_ROOT + "/articles/{codeArticle}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Rechercher un article", notes = "Cette methode permet de chercher un article par son Code", response = ArticleDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "l'article a ete trouver dans la BDD"),
            @ApiResponse(code = 404, message = "Aucun Article n'existe dans la BDD avec Code fourni")
    })
    ArticleDto findByCodeArticle(@PathVariable("codeArticle") String codeArticle);


    @GetMapping(value = APP_ROOT + "/articles/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des articles", notes = "Cette methode permet de chercher etrenvoyer la liste des articles qui existe dans la BDD", responseContainer = "List<ArticleDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "la liste des Article / Liste vide")
    })
    List<ArticleDto> findAll();



    @DeleteMapping(value = APP_ROOT + "/articles/delete/{idArticle}")
    @ApiOperation(value = "Supprimer un article", notes = "Cette methode permet de supprimer un articles par ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "l'article est supprimer'")
    })
    void  delete(@PathVariable("idArticle") Integer id);
}
