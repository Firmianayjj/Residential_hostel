package com.example.residentialhostel.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.residentialhostel.pojo.model.User;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
* @author yejiajian
* @description 针对表【user(用户)】的数据库操作Service
* @createDate 2024-01-22 15:25:52
*/
public interface UserService extends IService<User> {
    /**
     * 用户注册接口，使用电话号码进行注册
     * @param userName
     * @param phoneNumber
     * @param userPassword
     * @param checkPassword
     * @return
     */
    int userRegister(String userName,String phoneNumber, String userPassword, String checkPassword);

    /**
     * 用户登录接口
     * @param userTelephone
     * @param userPassword
     * @Param request
     * @return
     */
    User doLogin(String userTelephone,String userPassword,HttpServletRequest request);

    /**
     * 用户信息的修改接口
     * @param userTelephone
     * @param userName
     * @param gender
     * @param age
     * @param request
     * @return
     */
    User modifyUserInformation(String userTelephone,String userName,String gender,String age,HttpServletRequest request);
}
