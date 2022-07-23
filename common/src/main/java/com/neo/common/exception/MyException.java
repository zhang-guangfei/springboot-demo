package com.neo.common.exception;

import lombok.Data;

@Data
public class MyException extends Exception {

    private int code;
    private String message;

    public MyException(String message) {
        super(message);
        this.code = 500;
    }

    public MyException(int code, String message) {
        super(message);
        this.code = code;
    }

    public MyException(String message, Throwable cause) {
        super(message, cause);
    }

    public MyException(int code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }


}
