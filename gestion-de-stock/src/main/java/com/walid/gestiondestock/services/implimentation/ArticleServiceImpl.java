package com.walid.gestiondestock.services.implimentation;

import com.walid.gestiondestock.dto.ArticleDto;
import com.walid.gestiondestock.exception.EntityNotFoundException;
import com.walid.gestiondestock.exception.ErrorCodes;
import com.walid.gestiondestock.exception.InvalidEntityException;
import com.walid.gestiondestock.model.Article;
import com.walid.gestiondestock.repository.ArticleRepository;
import com.walid.gestiondestock.services.ArticleService;
import com.walid.gestiondestock.validator.ArticleValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
//@Service("articleServiceImpl1")
@Slf4j // log
public class ArticleServiceImpl implements ArticleService {


    private ArticleRepository articleRepository;

    @Autowired
    public ArticleServiceImpl(ArticleRepository articleRepository){
    this.articleRepository = articleRepository;

    }




    @Override
    public ArticleDto save(ArticleDto dto) {


        List<String> errors = ArticleValidator.Validate(dto); // vérification de validité de l'article avans l'enregistrer a la bdd
        if (!errors.isEmpty()){

            log.error("Article is not valide {}", dto);
            throw new InvalidEntityException("L'article n'est pas valide", ErrorCodes.ARTICLE_NOT_VALID, errors);
        }


        return ArticleDto.fromEntity(

                articleRepository.save(
                        ArticleDto.toEntity(dto)
                )
        ) ;
    }

    @Override
    public ArticleDto findById(Integer id) {


        if (id == null){

            log.error("Article Id is null");
            return null;
        }

        Optional<Article> article = articleRepository.findById(id);

        return Optional.of(ArticleDto.fromEntity(article.get())).orElseThrow(()->
                new EntityNotFoundException(
                        "Aucun article avec l'ID = " + id + " n'est trouve dans la BDD",
                        ErrorCodes.ARTICLE_NOT_FOUND)
        );
    }

    @Override
    public ArticleDto findByCodeArticle(String codeArticle) {


        if (!StringUtils.hasLength(codeArticle)) {

            log.error("Article CODE is null");
            return null;
        }


        Optional<Article> article = articleRepository.findArticleByCodeArticle(codeArticle);

        return Optional.of(ArticleDto.fromEntity(article.get())).orElseThrow(()->
                new EntityNotFoundException(
                        "Aucun article avec le code  = " + codeArticle + " n'est trouve dans la BDD",
                        ErrorCodes.ARTICLE_NOT_FOUND)
        );
    }

    @Override
    public List<ArticleDto> findAll() {
        return articleRepository.findAll().stream()
                .map(ArticleDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {

        if (id == null){

            log.error("Article Id is null");
            return ;
        }
        articleRepository.deleteById(id);



    }
}
