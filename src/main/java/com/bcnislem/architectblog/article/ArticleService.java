package com.bcnislem.architectblog.article;

import java.util.List;
import java.util.Optional;

public interface ArticleService {

    // create
    Article addArticle (Article article);

    // get all
    List<Article> getAllArticles ();

    // get by id
    Optional<Article> getArticle (Integer article_id) throws Exception;

    // update
    Article updateArticle (Article article);

    // delete
    void deleteArticle (Integer article_id);
}
