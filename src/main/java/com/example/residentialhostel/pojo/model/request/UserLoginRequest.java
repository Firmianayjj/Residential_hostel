package com.example.residentialhostel.pojo.model.request;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户登录请求体
 */
@Data
public class UserLoginRequest implements Serializable {

    private static final long serialVersionUID = 2112611146646056037L;

    private String userTelephone;
    private String userPassword;
}
