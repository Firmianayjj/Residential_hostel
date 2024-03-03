package com.example.residentialhostel.utils;

import com.example.residentialhostel.common.BaseResponse;
import com.example.residentialhostel.common.ErrorCode;
import org.springframework.stereotype.Component;

/**
 * 返回工具类
 */
@Component
public class ResultUtils {
    /**
     * 成功
     * @param data
     * @param <T>
     * @return
     */
    public static <T> BaseResponse<T> success(T data){
        return new BaseResponse<>(200,data,"ok");
    }

    /**
     * 失败
     * @param errorCode
     * @return
     */
    public static BaseResponse error(ErrorCode errorCode){
        return new BaseResponse(errorCode);
    }


    /**
     * 失败
     * @param code
     * @param message
     * @param descrption
     * @return
     */
    public static BaseResponse error(int code,String message,String descrption){
        return new BaseResponse(code,message,descrption);
    }

    /**
     * 失败
     * @param errorCode
     * @param message
     * @param descrption
     * @return
     */
    public static BaseResponse error(ErrorCode errorCode, String message, String descrption){
        return new BaseResponse(errorCode.getCode(),message,descrption);
    }

    /**
     * 失败
     * @param errorCode
     * @param descrption
     * @return
     */
    public static BaseResponse error(ErrorCode errorCode,String descrption){
        return new BaseResponse(errorCode.getCode(),errorCode.getMsg(),descrption);
    }
}
