package com.example.demo.controller;

import com.example.demo.properties.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * Created by 王成达 on 2017/11/7.
 */
@RestController
public class HelloController {

    @Value("${cupSize}")
    String cupSize;

    @Value("${age}")
    Integer age;

    @Value("${content}")
    String content;


    @Autowired
    private GirlProperties girlProperties;

//    @RequestMapping(value = "/hello/{id}",method = RequestMethod.GET)
    @GetMapping(value = "/hello/{id}")
    public String say(@PathVariable("id")Integer id){
        return "hello world! " + girlProperties.getCupSize()+"-"+girlProperties.age+":"+id;
    }

    @RequestMapping(value = "/hello2",method = RequestMethod.GET)
    public String say1(@RequestParam(value = "id",required = false,defaultValue = "0")Integer id){
        return "hello world! " + girlProperties.getCupSize()+"-"+girlProperties.age+":"+id;
    }
}
