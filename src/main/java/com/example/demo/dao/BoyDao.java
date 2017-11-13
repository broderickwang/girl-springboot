package com.example.demo.dao;

import com.example.demo.domain.Boy;
import com.example.demo.domain.Result;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/*************************
 * Created by Broderick
 * Project:demo
 * Version:1.0
 * Time:十一月
 *************************/

@Mapper
public interface BoyDao {

    int inserBoy(Boy boy);

    Boy selectone(Integer id);

    Boy findByName(@Param("name") String name);

}
