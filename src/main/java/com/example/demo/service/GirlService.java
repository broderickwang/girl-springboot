package com.example.demo.service;

import com.example.demo.domain.Girl;
import com.example.demo.enums.ResultEnum;
import com.example.demo.exception.GirlException;
import com.example.demo.reposity.GirlReposity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    public void getAge(Integer id) throws Exception{
        Girl girl = girlReposity.getOne(id);
        Integer age = girl.getAge();
        if(age < 10){
            //code 100
            throw new GirlException(ResultEnum.PRIMARY_SCHOOL);
        }else if (age>10 && age<16){
            //code 101
            throw new GirlException(ResultEnum.MIDDLE_SCHOOL);
        }
    }


    /**
     * 通过ID查询一个女生
     * @param id
     * @return
     */
    public Girl findOne(Integer id){
        return girlReposity.findOne(id);
    }
}
