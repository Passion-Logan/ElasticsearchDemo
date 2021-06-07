package com.cody.demo.document;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * @author wql
 * @desc Bank
 * @date 2021/6/7
 * @lastUpdateUser wql
 * @lastUpdateDesc
 * @lastUpdateTime 2021/6/7
 */
@Document(indexName = "bank")
@Data
public class Bank {

    private String address;
    private String city;
    private String email;
    private String employer;
    private String firstname;
    private String gender;
    private String lastname;
    private String state;
    private Integer account_number;
    private Integer age;
    private Integer balance;

}
