package com.example.demo.service.impl;

import com.example.demo.dao.BoyDao;
import com.example.demo.domain.Boy;
import com.example.demo.domain.Result;
import com.example.demo.service.BoyService;
import com.example.demo.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*************************
 * Created by Broderick
 * Project:demo
 * Version:1.0
 * Time:十一月
 *************************/
@Service
public class BoyServiceImpl  implements BoyService{

    @Autowired
    BoyDao boyDao;

    @Override
    public List<Boy> getBoysByName(String name) {
        return null;
    }

    @Override
    public List<Boy> getBoysByCupName(String cupname) {
        return null;
    }

    @Override
    public int insertBoy(Boy boy) {
        return boyDao.inserBoy(boy);
    }

    @Override
    public Boy selectone(Integer id) {
        return boyDao.selectone(id);
    }

    @Override
    public List<Boy> findByName(String userName) {
        return boyDao.findByName(userName);
    }
}
