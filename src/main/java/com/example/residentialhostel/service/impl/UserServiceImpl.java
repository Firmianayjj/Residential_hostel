package com.example.residentialhostel.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.residentialhostel.pojo.model.User;
import com.example.residentialhostel.service.UserService;
import com.example.residentialhostel.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author yejiajian
* @description 针对表【user(用户)】的数据库操作Service实现
* @createDate 2024-01-19 16:24:06
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

}




