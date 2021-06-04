package com.cody.demo.service;

import com.cody.demo.document.Article;
import org.springframework.data.elasticsearch.core.SearchHits;

public interface ArticleService {

    Article findById(String id);

    void removeById(String id);

    String save(Article article);

    SearchHits<Article> getPage(Integer page, Integer pageSize);
}
