package com.example.demo.service.impl;

import com.example.demo.dao.CityDao;
import com.example.demo.domain.City;
import com.example.demo.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*************************
 * Created by Broderick
 * Project:demo
 * Version:1.0
 * Time:十一月
 *************************/
@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityDao cityDao;

    @Override
    public City findCityByName(String cityName) {
        return cityDao.findByName(cityName);
    }
}
