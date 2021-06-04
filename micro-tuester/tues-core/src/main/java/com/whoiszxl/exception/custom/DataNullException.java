package com.whoiszxl.exception.custom;

import com.whoiszxl.bean.Result;

/**
 * 校验异常
 *
 * @author whoiszxl
 * @date 2021/3/17
 */
public class DataNullException extends RuntimeException {

    //错误代码
    private final Result result;

    public DataNullException(Result result){
        this.result = result;
    }
    public Result getResult(){
        return result;
    }
}