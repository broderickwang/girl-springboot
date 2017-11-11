package com.example.demo;

import com.example.demo.domain.Girl;
import com.example.demo.service.GirlService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 对service的测试
 * Created by 王成达 on 2017/11/11.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class GirlServiceTest {
    @Autowired
    private GirlService girlService;

    @Test
    public void findOneTest(){
        Girl girl = girlService.findOne(21);
        //断言
        Assert.assertEquals(new Integer(14),girl.getAge());
    }
}
