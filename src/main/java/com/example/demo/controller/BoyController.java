package com.example.demo.controller;

import com.example.demo.domain.Boy;
import com.example.demo.domain.Result;
import com.example.demo.service.BoyService;
import com.example.demo.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/*************************
 * Created by Broderick
 * Project:demo
 * Version:1.0
 * Time:十一月
 *************************/
@RestController
public class BoyController {

    @Autowired
    BoyService boyService;

    @PostMapping(value = "/inb")
    public String inserBoy(Boy boy){
        boy.setName(boy.getName());
        boy.setNameCap(boy.getNameCap());

        int i =  boyService.insertBoy(boy);
        return "ddddd:"+i;
    }

    @GetMapping("/get/{id}")
    public Result getone(@PathVariable("id")Integer id){
        return ResultUtil.success(boyService.selectone(id));
    }

    @PostMapping("/boy/name")
    public Result name(@RequestParam("name")String  name){
        return ResultUtil.success(boyService.findByName(name));
    }
}
