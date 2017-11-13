package com.example.demo.service;

import com.example.demo.domain.City;

/*************************
 * Created by Broderick
 * Project:demo
 * Version:1.0
 * Time:十一月
 *************************/
public interface CityService {

    City findCityByName(String cityName);
}
