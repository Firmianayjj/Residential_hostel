package com.example.residentialhostel.service.impl;
import java.util.Date;

import cn.hutool.core.lang.UUID;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.digest.DigestUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.residentialhostel.pojo.model.User;
import com.example.residentialhostel.service.UserService;
import com.example.residentialhostel.mapper.UserMapper;
import com.example.residentialhostel.utils.UserUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
* @author yejiajian
* @description 针对表【user(用户)】的数据库操作Service实现
* @createDate 2024-01-22 15:25:52
*/
@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

    @Resource
    private UserMapper userMapper;
    @Resource
    private UserUtils userUtils;

    private final static String SALT="yjj";
    private final static String USER_LOGIN_STATE="userLoginState";
    private final static Pattern checkTelephone=Pattern.compile("^((17[0-9])|(14[0-9])|(13[0-9])|(15[0-9])|(16[0-9])|(18[0-9])|(19[0-9]))\\d{8}$");
    private final static Pattern checkName=Pattern.compile("^\\w{3,20}$");

    /**
     * 用户注册
     * @param userName
     * @param phoneNumber
     * @param userPassword
     * @param checkPassword
     * @return
     */
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

    /**
     * 用户登录
     * @param userTelephone
     * @param userPassword
     * @param request
     * @return
     */
    @Override
    public User doLogin(String userTelephone, String userPassword, HttpServletRequest request) {
        //1.校验
        if(StrUtil.hasEmpty(userPassword,userTelephone)){
            return null;
        }
        if(userPassword.length()<8){
            return null;
        }
        //校验用户的手机号是否合法
        if(!checkTelephone.matcher(userTelephone).matches()){
            return null;
        }
        //2.对密码进行加密比对
        String encryptPassword=DigestUtil.md5Hex(userPassword+SALT);
        QueryWrapper<User> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("phone_number",userTelephone);
        queryWrapper.eq("password",encryptPassword);
        User user = userMapper.selectOne(queryWrapper);
        if(user==null){
            log.info("user login failed");
            return null;
        }
        //3.用户脱敏
        User safetyUser = userUtils.userDesensitize(user);

        //4.记录用户的登录态
        request.getSession().setAttribute(USER_LOGIN_STATE,safetyUser);
        return safetyUser;
    }

    /**
     * 修改用户信息
     * @param userTelephone
     * @param userName
     * @param gender
     * @param age
     * @param request
     * @return
     */
    @Override
    public User modifyUserInformation(String userTelephone, String userName, String gender, String age, HttpServletRequest request) {
        //1.校验
        if(StrUtil.hasEmpty(userTelephone,userName,gender,age)){
            return null;
        }
        if(!"男".equals(gender)&&!"女".equals(gender)){
            return null;
        }
        if(Integer.parseInt(age)<18||Integer.parseInt(age)>100){
            return null;
        }
        QueryWrapper<User> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("phone_number",userTelephone);
        User user = userMapper.selectOne(queryWrapper);
        if(user==null){
            log.info("user not exit");
            return null;
        }
        user.setPhoneNumber(userTelephone);
        user.setUserName(userName);
        user.setUserAge(age);
        user.setUserGender(gender);

        userMapper.updateById(user);
        //3.用户脱敏
        User safetyUser = userUtils.userDesensitize(user);
        //4.记录用户的登录态
        request.getSession().setAttribute(USER_LOGIN_STATE,safetyUser);
        return safetyUser;
    }


}




