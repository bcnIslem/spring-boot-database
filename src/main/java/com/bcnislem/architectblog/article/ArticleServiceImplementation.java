package com.bcnislem.architectblog.article;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ArticleServiceImplementation implements ArticleService {

    private ArticleRepository articleRepository;

    @Override
    public Article addArticle(Article article) {
        return articleRepository.save(article);
    }

    @Override
    public List<Article> getAllArticles() {
        return articleRepository.findAll();
    }

    @Override
    public Optional<Article> getArticle(Integer article_id) throws Exception {
        return Optional.ofNullable(articleRepository.findById(article_id)
                .orElseThrow(() -> new Exception("Article not found!")));
    }

    @Override
    public Article updateArticle(Article article) {
        return articleRepository.save(article);
    }

    @Override
    public void deleteArticle(Integer article_id) {
        articleRepository.deleteById(article_id);
    }
}
