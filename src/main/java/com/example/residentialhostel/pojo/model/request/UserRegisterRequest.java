package com.example.residentialhostel.pojo.model.request;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户注册请求体
 */
@Data
public class UserRegisterRequest implements Serializable {
    private static final long serialVersionUID = -1421436030845638419L;

    private String userName;
    private String phoneNumber;
    private String userPassword;
    private String checkPassword;
}
