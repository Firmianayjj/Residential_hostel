package com.example.residentialhostel.Service;

import com.example.residentialhostel.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    void testUserRegister() {
        String userName="yejiajian";
        String userPassword="296587571";
        String checkPassword="296587571";
        String phone="15015132722";
        int result = userService.userRegister(userName, phone, userPassword, checkPassword);
        Assertions.assertEquals(1,result);
    }
}
