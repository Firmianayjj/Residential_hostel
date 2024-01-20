package com.example.residentialhostel.exception;

import com.example.residentialhostel.common.BaseResponse;
import com.example.residentialhostel.common.ErrorCode;
import com.example.residentialhostel.utils.ResultUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理器
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandle {

    @ExceptionHandler(BusinessException.class)
    public BaseResponse businessExceptionHandle(BusinessException e){
        log.error("BusinessException: "+e.getMessage(),e);
        return ResultUtils.error(e.getCode(),e.getMessage(),e.getMessage());
    }

    @ExceptionHandler(RuntimeException.class)
    public BaseResponse businessExceptionHandle(RuntimeException e){
        log.error("RuntimeException",e);
        return ResultUtils.error(ErrorCode.SYSTEM_ERROR,e.getMessage(),"");
    }
}
