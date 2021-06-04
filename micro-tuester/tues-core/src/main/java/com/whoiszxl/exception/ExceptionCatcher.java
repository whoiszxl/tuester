package com.whoiszxl.exception;

import com.whoiszxl.bean.Result;
import com.whoiszxl.exception.custom.DataNullException;
import com.whoiszxl.exception.custom.JwtAuthException;
import com.whoiszxl.exception.custom.ValidateException;

/**
 * 异常捕获
 *
 * @author whoiszxl
 * @date 2021/3/17
 */
public class ExceptionCatcher {

    public static void catchAuthFailEx(){
        throw new JwtAuthException();
    }

    public static void catchValidateEx(Result result){
        throw new ValidateException(result);
    }

    public static void catchNullEx(Result result) {
        throw new DataNullException(result);
    }

}