package com.example.demo.handle;

import com.example.demo.domain.Result;
import com.example.demo.exception.GirlException;
import com.example.demo.util.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by 王成达 on 2017/11/11.
 */

@ControllerAdvice
public class ExceptionHandle {

    //记录异常日志
    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e){
        if(e instanceof GirlException){
            GirlException girlException = (GirlException) e;
            return ResultUtil.failed(girlException.getCode(), girlException.getMessage());
        }else {
            //如果是不可知的异常，进行日志记录
            logger.error("【系统异常】{}",e);
            return ResultUtil.failed(-1, "未知错误");
        }
    }
}
