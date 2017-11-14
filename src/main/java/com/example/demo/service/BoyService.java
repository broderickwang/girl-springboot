package com.example.demo.service;

import com.example.demo.domain.Boy;
import com.example.demo.domain.Result;

import java.util.List;

/*************************
 * Created by Broderick
 * Project:demo
 * Version:1.0
 * Time:十一月
 *************************/
public interface BoyService {

    List<Boy> getBoysByName(String name);

    List<Boy> getBoysByCupName(String cupname);

    int insertBoy(Boy boy);

    Boy selectone (Integer id);

    List<Boy> findByName(String userName);
}
