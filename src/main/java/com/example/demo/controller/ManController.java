package com.example.demo.controller;

import com.example.demo.domain.City;
import com.example.demo.domain.Girl;
import com.example.demo.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/*************************
 * Created by Broderick
 * Project:demo
 * Version:1.0
 * Time:十一月
 *************************/
@Controller
public class ManController {

    @Autowired
    private CityService cityService;

    @GetMapping("/one")
    public ModelAndView one(){
        ModelAndView mav = new ModelAndView("one");
        Girl g = new Girl();
        g.setAge(11);
        g.setCupSize("b");
        g.setId(13);
        mav.addObject("g", g);
        return mav;
    }

    @GetMapping("/getCity")
    public ModelAndView getCityList(@RequestParam("cityname") String cityName){
        City c = cityService.findCityByName(cityName);
        ModelAndView mav = new ModelAndView("city");

        mav.addObject("city", c);
        return mav;
    }

    @ResponseBody
    @GetMapping("/getCity2")
    public String getCityList2(@RequestParam("cityname") String cityName){
        City c = cityService.findCityByName(cityName);

        return c.toString();
    }
}
