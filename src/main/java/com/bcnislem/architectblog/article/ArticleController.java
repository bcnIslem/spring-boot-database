package com.bcnislem.architectblog.article;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/articles")
public class ArticleController {
    private ArticleService articleService;

    @GetMapping("/all")
    public ResponseEntity<List<Article>> getAllArticles () {
        return new ResponseEntity<>(articleService.getAllArticles(), HttpStatus.OK);
    }

    @GetMapping("/article/{article_id}")
    public ResponseEntity<Article> getArticle(@PathVariable("article_id") Integer article_id) throws Exception {
        return articleService.getArticle(article_id).map(ResponseEntity :: ok)
                .orElseGet(()-> ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    public ResponseEntity<Article> addArticle (@RequestBody Article article) {
        return new ResponseEntity<>(articleService.addArticle(article), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Article> updateArticle (@RequestBody Article article) {
        return new ResponseEntity<>(articleService.updateArticle(article), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{article_id}")
    public void deleteArticle (@PathVariable("article_id") Integer article_id) {
        articleService.deleteArticle(article_id);
    }

}
