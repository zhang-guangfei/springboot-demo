package com.neo.common.exception;

import com.neo.common.dto.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {


    /*捕获业务异常*/
    @ExceptionHandler(MyException.class)
    public Result handleMyException(MyException e) {
        e.printStackTrace();
        return Result.failure(e);
    }

    /*捕获未处理的异常*/
    @ExceptionHandler(Exception.class)
    public Result handleException(Exception e) {
        e.printStackTrace();
        return Result.failure(500, "未处理的异常", e.getCause());
    }



}
