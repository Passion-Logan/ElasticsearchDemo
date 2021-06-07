package com.cody.demo.service.impl;

import com.cody.demo.document.Article;
import com.cody.demo.document.Bank;
import com.cody.demo.repository.ArticleRepository;
import com.cody.demo.service.TestService;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * ArticleServiceImpl
 *
 * @author wql
 * @desc ArticleServiceImpl
 * @date 2021/6/4
 * @lastUpdateUser wql
 * @lastUpdateDesc
 * @lastUpdateTime 2021/6/4
 */
@Service
public class TestServiceImpl implements TestService {

    @Resource
    private ArticleRepository articleRepository;
    @Autowired
    private ElasticsearchRestTemplate elasticsearchRestTemplate;
    @Autowired
    private ElasticsearchOperations elasticsearchOperations;

    @Override
    public Article findById(String id) {
        Optional<Article> article = articleRepository.findById(id);
        return article.orElse(null);
    }

    @Override
    public void removeById(String id) {
        articleRepository.deleteById(id);
    }

    @Override
    public String save(Article article) {
        articleRepository.save(article);
        return Objects.isNull(article.getId()) ? "保存失败" : "保存成功";
    }

    @Override
    public SearchHits<Article> getPage(Integer page, Integer pageSize) {
        NativeSearchQuery query = new NativeSearchQuery(new BoolQueryBuilder());
        query.setPageable(PageRequest.of(page, pageSize));

        SearchHits<Article> searchHits = elasticsearchRestTemplate.search(query, Article.class);
        return searchHits;
    }

    @Override
    public SearchHits<Bank> getBankPage(Integer page, Integer pageSize) {
        NativeSearchQuery query = new NativeSearchQuery(new BoolQueryBuilder());
        query.setPageable(PageRequest.of(page, pageSize));

//        SearchHits<Bank> searchHits = elasticsearchRestTemplate.search(query, Bank.class);
        SearchHits<Bank> searchHits = elasticsearchOperations.search(query, Bank.class);

        List<Bank> collect = searchHits.getSearchHits().stream().map(SearchHit::getContent).collect(Collectors.toList());
        System.out.println(collect);

        return searchHits;
    }

}
