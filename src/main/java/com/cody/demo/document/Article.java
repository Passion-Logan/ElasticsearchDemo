package com.cody.demo.document;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

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

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime createTime;

}
