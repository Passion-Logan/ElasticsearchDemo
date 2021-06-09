package com.cody.demo.controller;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONUtil;
import com.cody.demo.document.Article;
import com.cody.demo.service.TestService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

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
    private TestService testService;
    @Resource
    private ObjectMapper jsonMapper;

    @GetMapping("test")
    public void test() throws JsonProcessingException {
        String t = "[{\"formId\": 1402073176056582145, \"tableName\": \"cas_test\", \"tableAlias\": \"级联选择器\", \"searchFields\": [\"column_0\", \"column_1\"], \"relationFields\": [\"column_0\"]}]";

        JSONArray objects = JSONUtil.parseArray(t);
        System.out.println(JSONUtil.parseObj(objects.get(0)).get("formId"));

        List<Map<String, Object>> list = jsonMapper.readValue(t, List.class);
        System.out.println(list.get(0).get("formId"));
    }

    @GetMapping("getInfo")
    public void getInfo(@RequestParam String id) {
        log.info("------getInfo{}", testService.findById(id));
    }

    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable String id) {
        testService.removeById(id);
        log.info("------delete{}", "删除成功");
    }

    @PostMapping("save")
    public void save(@RequestBody Article article) {
        log.info("------save{}", testService.save(article));
    }

    @GetMapping("getPage")
    public void getPage(@RequestParam(defaultValue = "1") Integer page,
                        @RequestParam(defaultValue = "10") Integer pageSize) {
        log.info("------getPage{}", testService.getPage(page, pageSize));
    }

    @GetMapping("getBankPage")
    public void getBankPage(@RequestParam(defaultValue = "1") Integer page,
                        @RequestParam(defaultValue = "10") Integer pageSize) {
        log.info("------getPage{}", testService.getBankPage(page, pageSize));
    }


}
