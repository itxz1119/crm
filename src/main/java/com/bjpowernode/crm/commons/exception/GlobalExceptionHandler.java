package com.bjpowernode.crm.commons.exception;

import com.bjpowernode.crm.commons.utils.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler{

    /*
    * 全局异常处理
    * */
    @ExceptionHandler(Exception.class)
    public Result error(Exception e){
        e.printStackTrace();
        return Result.fail(null).message("执行了全局异常");
    }

    /*
     * 特定异常处理
     * */
    @ExceptionHandler(CrmException.class)
    public Result error(CrmException e){
        e.printStackTrace();
        return Result.fail(null).code(e.getCode()).message(e.getMessage());
    }
}
