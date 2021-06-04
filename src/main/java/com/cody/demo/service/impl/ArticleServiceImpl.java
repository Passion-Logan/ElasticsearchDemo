package com.cody.demo.service.impl;

import com.cody.demo.document.Article;
import com.cody.demo.repository.ArticleRepository;
import com.cody.demo.service.ArticleService;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Objects;
import java.util.Optional;

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
public class ArticleServiceImpl implements ArticleService {

    @Resource
    private ArticleRepository articleRepository;
    @Autowired
    private ElasticsearchRestTemplate elasticsearchRestTemplate;

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
//        articleRepository.save(article);
//        return Objects.isNull(article.getId()) ? "保存失败" : "保存成功";
        System.out.println(article.toString());
        return "";
    }

    @Override
    public SearchHits<Article> getPage(Integer page, Integer pageSize) {

        NativeSearchQuery query = new NativeSearchQuery(new BoolQueryBuilder());
        query.setPageable(PageRequest.of(page, pageSize));

        SearchHits<Article> searchHits = elasticsearchRestTemplate.search(query, Article.class);
        return searchHits;
    }

}
