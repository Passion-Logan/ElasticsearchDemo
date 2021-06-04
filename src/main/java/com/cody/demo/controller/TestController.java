package com.cody.demo.controller;

import com.cody.demo.document.Article;
import com.cody.demo.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author wql
 * @desc TestController
 * @date 2021/6/4
 * @lastUpdateUser wql
 * @lastUpdateDesc
 * @lastUpdateTime 2021/6/4
 */
@RestController
@Slf4j
public class TestController {

    @Autowired
    private ArticleService articleService;

    @GetMapping("getInfo")
    public void getInfo(@RequestParam String id) {
        System.out.println();
        log.info("------getInfo{}", articleService.findById(id));
    }

    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable String id) {
        articleService.removeById(id);
        log.info("------delete{}", "删除成功");
    }

    @PostMapping("save")
    public void save(@RequestBody Article article) {
        log.info("------save{}", articleService.save(article));
    }

    @GetMapping("getPage")
    public void getPage(@RequestParam(defaultValue = "1") Integer page,
                        @RequestParam(defaultValue = "10") Integer pageSize) {
        log.info("------getPage{}", articleService.getPage(page, pageSize));
    }


}
