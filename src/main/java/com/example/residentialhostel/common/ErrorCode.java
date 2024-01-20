package com.example.residentialhostel.common;

/**
 * 全局异常处理类
 */
public enum ErrorCode {
    PARAMS_ERROR(40000,"请求参数错误",""),
    PARAMS_NULL_ERROR(40001,"请求参数错误",""),
    NOT_LOGIN(40100,"未登录",""),
    NO_AUTH(40100,"没权限",""),
    SYSTEM_ERROR(50000,"系统内部异常","");



    private int code;

    /**
     * 状态码信息
     */
    private final String msg;

    /**
     * 状态码描述（详情）
     */
    private final String description;

    ErrorCode(int code, String msg, String description) {
        this.code = code;
        this.msg = msg;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public String getDescription() {
        return description;
    }
}
