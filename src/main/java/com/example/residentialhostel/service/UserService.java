package com.example.residentialhostel.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.residentialhostel.pojo.model.User;

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
}
