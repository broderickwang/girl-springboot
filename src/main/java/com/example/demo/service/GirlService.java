package com.example.demo.service;

import com.example.demo.domain.Girl;
import com.example.demo.reposity.GirlReposity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by 王成达 on 2017/11/8.
 */
@Service
public class GirlService {

    @Autowired
    private GirlReposity girlReposity;

    //事务控制
    @Transactional
    public void insertTwo(){
        Girl a = new Girl();
        a.setAge(23);
        a.setCupSize("A");

        girlReposity.save(a);

        Girl b = new Girl();
        b.setAge(19);
        b.setCupSize("B");
        girlReposity.save(b);
    }
}
