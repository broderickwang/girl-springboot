package com.example.demo.util;

import com.example.demo.domain.Result;

/**
 * Created by 王成达 on 2017/11/11.
 */
public class ResultUtil {
    public static Result success(Object object){
        Result result = new Result();
        result.setCode(0);
        result.setMsg("");
        result.setData(object);
        return result;
    }

    public static Result success(){
        return success(null);
    }

    public static Result failed(Integer code,String msg){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(null);
        return result;
    }
}
