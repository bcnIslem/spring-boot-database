package com.bcnislem.architectblog.article;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@Entity
@Table(name = "article")
@NoArgsConstructor
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer article_id;
    private String title;
    private String content;

    public Article (String title, String content) {
        this.title = title;
        this.content = content;
    }

}
