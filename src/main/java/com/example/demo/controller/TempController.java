package com.example.demo.controller;

import com.example.demo.domain.User;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * Created by 王成达 on 2017/11/7.
 */
@Controller
public class TempController {




    @RequestMapping(value = "/sey",method = RequestMethod.GET)
    public String sey(ModelMap model, HttpSession session){
        model.put("now", new Date());
        model.put("message", "Welcome to BeiJing!");
        model.put("umessage","<b>Welcome to BeiJing!</b>");
        model.put("rememberme",true);
        model.put("bgcolor","#abcdef");
        model.put("user",new User("fanlychie", "男", 24));
        session.setAttribute("user", new User("fanlychie", "男", 24));
        return "index";
    }
}
