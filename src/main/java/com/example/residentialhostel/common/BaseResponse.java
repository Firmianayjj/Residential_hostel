package com.example.residentialhostel.common;

import java.io.Serializable;

/**
 * 通用返回类
 * @param <T>
 */
public class BaseResponse<T> implements Serializable {
    private int code;
    private String msg;
    private T data;
    private String description;

    public BaseResponse(int code,String msg,T data,String description){
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.description=description;
    }

    public BaseResponse(int code, T data,String message) {
        this(code, message, data,"");
    }

    public BaseResponse(int code, T data) {
        this(code, "",data,"");
    }

    public BaseResponse(ErrorCode errorCode){
        this(errorCode.getCode(),errorCode.getMsg(),null,errorCode.getDescription());
    }
}
