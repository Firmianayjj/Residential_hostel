package com.example.residentialhostel.utils;

import cn.hutool.core.util.StrUtil;
import com.example.residentialhostel.enums.ROLE;
import com.example.residentialhostel.pojo.model.User;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * 用户工具类
 */
@Component
public class UserUtils {

    /**
     * 用于在返回用户信息的时候进行用户信息的脱敏，避免敏感信息泄漏
     * @param user
     * @return
     */
    public User userDesensitize(User user){
        //3.用户脱敏
        User safetyUser = new User();
        safetyUser.setUserId(user.getUserId());
        safetyUser.setPhoneNumber(user.getPhoneNumber());
        safetyUser.setUserName(user.getUserName());
        safetyUser.setUserGender(user.getUserGender());
        safetyUser.setUserNumber(user.getUserNumber());
        safetyUser.setUserAge(user.getUserAge());
        safetyUser.setExamineState(user.getExamineState());
        //用户类型
        safetyUser.setUserType(user.getUserType());
        safetyUser.setCreateTime(user.getCreateTime());
        return safetyUser;
    }

    /**
     * 用于对用户的身份信息做解析，100代表管理员，001代表租客，而相对较少的010代表房主
     * @param userType
     * @return
     */
    public HashSet<String> getUserRole(int userType){
        HashSet<String> userRoles = new HashSet<>();
        //得到当前用户类型的位数 如果是1位，可能为0或1
        String userTypeStr = String.valueOf(userType);
        String finalTypeStr = new StringBuilder(userTypeStr).reverse().toString();
        for(int i=0;i<finalTypeStr.length();i++){
            char mod = finalTypeStr.charAt(i);
            if(i==0&&mod=='1'){
                userRoles.add(ROLE.TENANT.toString());
            }
            if(i==1&&mod=='1'){
                userRoles.add(ROLE.LANDLORD.toString());
            }
            if(i==2&&mod=='1'){
                userRoles.add(ROLE.ADMINISTRATOR.toString());
            }
        }

        return userRoles;
    }

}
