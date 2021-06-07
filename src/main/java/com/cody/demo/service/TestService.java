package com.cody.demo.service;

import com.cody.demo.document.Article;
import com.cody.demo.document.Bank;
import org.springframework.data.elasticsearch.core.SearchHits;

public interface TestService {

    Article findById(String id);

    void removeById(String id);

    String save(Article article);

    SearchHits<Article> getPage(Integer page, Integer pageSize);

    SearchHits<Bank> getBankPage(Integer page, Integer pageSize);
}
