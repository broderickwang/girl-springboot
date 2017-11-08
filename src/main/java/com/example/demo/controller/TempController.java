package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 王成达 on 2017/11/7.
 */
@RestController
public class TempController {

    @RequestMapping(value = "/sey",method = RequestMethod.GET)
    public String sey(){
        return "index";
    }
}
