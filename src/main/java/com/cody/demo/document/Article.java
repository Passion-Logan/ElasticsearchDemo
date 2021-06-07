package com.cody.demo.document;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * @author wql
 * @desc Article
 * @date 2021/6/4
 * @lastUpdateUser wql
 * @lastUpdateDesc
 * @lastUpdateTime 2021/6/4
 */
@Document(indexName = "article")
@Data
@Accessors(chain = true)
public class Article {

    private String id;

    private String title;

    private String content;

    private Integer userId;

    private String createTime;

}
