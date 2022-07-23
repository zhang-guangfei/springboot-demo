package com.neo.common.dto;

import com.neo.common.exception.MyException;
import lombok.Data;

@Data
public class Result<T> {
    private int code;
    private String message;
    private T data;

    Result(int code, String message) {
        this.code = code;
        this.message = message;
    }


    Result(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public boolean isSuccess(){
        return code==200;
    }


    public static <T> Result success(String message) {
        return new Result<>(200, message);
    }

    public static <T> Result success(String message, T data) {
        return new Result<>(200, message, data);
    }

    public static <T> Result failure(String message) {
        return new Result<>(500, message);
    }

    public static <T> Result failure(int code, String message) {
        return new Result<>(code, message);
    }

    public static <T> Result failure(int code, String message, T data) {
        return new Result<>(code, message, data);
    }

    public static <T> Result failure(MyException e) {
        return new Result<>(e.getCode(), e.getMessage(), e.getCause());
    }


}
