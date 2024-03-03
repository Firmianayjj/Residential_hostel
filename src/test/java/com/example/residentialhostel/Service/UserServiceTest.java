package com.example.residentialhostel.Service;

import com.example.residentialhostel.enums.ROLE;
import com.example.residentialhostel.service.UserService;
import com.example.residentialhostel.utils.UserUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;


@SpringBootTest
@Slf4j
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Autowired
    private UserUtils userUtils;

    @Test
    void testUserRegister() {
        String userName="yejiajian";
        String userPassword="296587571";
        String checkPassword="296587571";
        String phone="15015132722";
        int result = userService.userRegister(userName, phone, userPassword, checkPassword);
        Assertions.assertEquals(1,result);
    }

    @Test
    void testUserUtilGETROLE(){
        int firstUserRole=101;
        int SecondUserRole=100;
        int ThirdUserRole=10;
//        HashSet<String> firstUserRoleSet = userUtils.getUserRole(firstUserRole);
        HashSet<String> SecondUserRoleSet = userUtils.getUserRole(SecondUserRole);
//        HashSet<String> ThirdUserRoleSet = userUtils.getUserRole(ThirdUserRole);
        if(SecondUserRoleSet.contains(ROLE.ADMINISTRATOR.toString())){
            log.info("true");
        }else {
            log.info("false");
        }
    }
}
