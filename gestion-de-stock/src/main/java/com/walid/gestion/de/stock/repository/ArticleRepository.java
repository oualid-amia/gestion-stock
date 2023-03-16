package com.walid.gestion.de.stock.repository;

import com.walid.gestion.de.stock.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ArticleRepository extends JpaRepository<Article, Integer>{


    Optional<Article> findArticleByCodeArticle (String codeArticle);



}
