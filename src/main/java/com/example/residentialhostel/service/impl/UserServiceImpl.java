package com.example.residentialhostel.service.impl;

import cn.hutool.core.lang.UUID;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.digest.DigestUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.residentialhostel.pojo.model.User;
import com.example.residentialhostel.service.UserService;
import com.example.residentialhostel.mapper.UserMapper;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
* @author yejiajian
* @description 针对表【user(用户)】的数据库操作Service实现
* @createDate 2024-01-22 15:25:52
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

    @Resource
    private UserMapper userMapper;

    @Override
    public int userRegister(String userName,String phoneNumber, String userPassword, String checkPassword) {
        //1.校验参数不为空
        if(StrUtil.hasEmpty(userName, userPassword, checkPassword)){
            return -1;
        }
        //2.校验用户密码和校验密码长度
        if (userPassword.length()<8||checkPassword.length()<8||!userPassword.equals(checkPassword)){
            return -1;
        }
        Pattern checkTelephone=Pattern.compile("^((17[0-9])|(14[0-9])|(13[0-9])|(15[0-9])|(16[0-9])|(18[0-9])|(19[0-9]))\\d{8}$");
        Pattern checkName=Pattern.compile("^\\w{3,20}$");
        Matcher matcherTelephone=checkTelephone.matcher(phoneNumber);
        Matcher matcherName=checkName.matcher(userName);
        //3.校验电话号码格式，如果不正确就返回电话号码格式不正确
        if(!matcherTelephone.matches()){
            return -1;
        }
        //4.校验用户名不包含特殊字符，如果不正确就返回用户名不允许包含特殊字符
        if(!matcherName.matches()){
            return -1;
        }
        //5.电话号码不能重复
        QueryWrapper<User> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("phone_number",phoneNumber);
        long count = userMapper.selectCount(queryWrapper);
        if(count>0){
            return -1;
        }
        //6.执行插入操作 密码要进行加密处理 使用hutool工具库md5算法进行摘要加密
        User user=new User();
        final String SALT="yjj";
        user.setPassword(DigestUtil.md5Hex(userPassword+SALT));
        user.setUserName(userName);
        //userNumber我选择自动生成uuid
        user.setUserNumber(IdUtil.simpleUUID());
        user.setPhoneNumber(phoneNumber);
        //默认所有人都可以是租客，即001
        user.setUserType(001);
        boolean saveResult = this.save(user);
        if(!saveResult){
            return -1;
        }
        return 1;
    }
}




