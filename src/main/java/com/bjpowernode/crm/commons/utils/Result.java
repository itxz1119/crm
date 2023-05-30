package com.bjpowernode.crm.commons.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> {
    private Integer code;
    private String message;
    private T data;

    public Result(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public static<T> Result ok(T data){
        Result<T> result = new Result<>(200,"请求成功!");
        if (data!=null){
            result.setData(data);
        }
        return result;
    }

    public static<T> Result fail(T data){
        Result<T> result = new Result<>(500,"请求失败!");
        if (data!=null){
            result.setData(data);
        }
        return result;
    }

    public Result code(Integer code){
        this.setCode(code);
        return this;
    }

    public Result message(String message){
        this.setMessage(message);
        return this;
    }
}
