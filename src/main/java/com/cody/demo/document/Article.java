package com.cody.demo.document;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.Date;

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
public class Article {

    @Id
    private String id;

    private String title;

    private String content;

    private Integer userId;

    private Date createTime;

}
