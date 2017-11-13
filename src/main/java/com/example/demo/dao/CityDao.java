package com.example.demo.dao;

import com.example.demo.domain.City;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

/*************************
 * Created by Broderick
 * Project:demo
 * Version:1.0
 * Time:十一月
 *************************/
@Mapper
@Component
public interface CityDao {

    @Select("select * from city")
    @Results({
            @Result(property = "id",column = "id"),
            @Result(property = "provinceId",column = "province_id"),
            @Result(property = "cityName",column = "city_name"),
            @Result(property = "description",column = "description")
    })
    City findByName(@Param("cityName")String cityName);
}
