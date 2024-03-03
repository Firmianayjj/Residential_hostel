package com.example.residentialhostel.controller;

import cn.hutool.core.util.StrUtil;
import com.example.residentialhostel.pojo.model.User;
import com.example.residentialhostel.pojo.model.request.UserLoginRequest;
import com.example.residentialhostel.pojo.model.request.UserRegisterRequest;
import com.example.residentialhostel.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = {"http://localhost:3000"})
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Integer userResigster(@RequestBody UserRegisterRequest userRegisterRequest) {
        if (userRegisterRequest == null) {
            return null;
        }
        String userName=userRegisterRequest.getUserName();
        String phoneNumber=userRegisterRequest.getPhoneNumber();
        String userPassword=userRegisterRequest.getUserPassword();
        String checkPasword=userRegisterRequest.getCheckPassword();
        if(StrUtil.hasEmpty(userName,phoneNumber,userPassword,checkPasword)){
            return null;
        }
        return userService.userRegister(userName, phoneNumber, userPassword, checkPasword);
    }

    @PostMapping("/doLogin")
    public User userLogin(@RequestBody UserLoginRequest userLoginRequest, HttpServletRequest httpServletRequest){
        if(userLoginRequest==null){
            return null;
        }
        String userTelephone = userLoginRequest.getUserTelephone();
        String userPassword = userLoginRequest.getUserPassword();
        if(StrUtil.hasEmpty(userPassword,userTelephone)){
            return null;
        }
        return userService.doLogin(userTelephone,userPassword,httpServletRequest);
    }
}
