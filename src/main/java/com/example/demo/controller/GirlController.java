package com.example.demo.controller;

import com.example.demo.domain.Girl;
import com.example.demo.domain.Result;
import com.example.demo.reposity.GirlReposity;
import com.example.demo.service.GirlService;
import com.example.demo.util.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by 王成达 on 2017/11/8.
 */
@RestController
public class GirlController {

    private final static Logger logger = LoggerFactory.getLogger(GirlController.class);

    @Autowired
    private GirlReposity girlReposity;

    @Autowired
    private GirlService service;

    /**
     * 查询女生列表
     * @return
     */
    @GetMapping(value = "/girls")
    public List<Girl> getGirls(){
        logger.info("获取所有的女生！");
        return girlReposity.findAll();
    }

    /**
     * 添加一个女生对象
     * @return
     */
    @PostMapping(value = "/girls")
    public Result<Girl> addGirl(@Valid Girl girl, BindingResult result){
        if(result.hasErrors()){
            return null;
//            return ResultUtil.failed(1,result.getFieldError().getDefaultMessage());
        }

        girl.setAge(girl.getAge());
        girl.setCupSize(girl.getCupSize());
        girl.setMoney(girl.getMoney());

        return ResultUtil.success(girl);
//        return girlReposity.save(girl);
    }

    /**
     * 通过ID查询
     * @param id
     * @return
     */
    @GetMapping("/getone")
    public String getOne(@RequestParam("id")Integer id){
        Girl g = girlReposity.getOne(id);
        return g.toString();
    }

    /**
     * 通过ID 更新女生
     * @param id
     * @param age
     * @param cupsize
     * @return
     */
    @PostMapping("/updateone")
    public Girl updateOne(@RequestParam("id")Integer id,@RequestParam("age")Integer age
            ,@RequestParam("cupsize")String cupsize){
        Girl girl = new Girl();
        girl.setCupSize(cupsize);
        girl.setAge(age);
        girl.setId(id);
//        Girl g = girlReposity.save(girl);
        return girlReposity.save(girl);
    }

    /**
     * 通过ID删除女生
     * @param id
     */
    @DeleteMapping("/delete")
    public void deleteone(@RequestParam("id")Integer id){
        girlReposity.delete(id);
    }

    /**
     * 通过年龄查询
     * @param age
     * @return
     */
    @GetMapping("/getbyage")
    public List<Girl> getbyAge(@RequestParam("age") Integer age){
        List<Girl> list = girlReposity.findByAge(age);
        return list;
    }

    @PostMapping("/girls/two")
    public void addTwoGirls(){
        service.insertTwo();
    }


    @GetMapping(value = "/girls/getAge/{id}")
    public void getAge(@PathVariable("id")Integer id) throws Exception{
        service.getAge(id);
    }
}
