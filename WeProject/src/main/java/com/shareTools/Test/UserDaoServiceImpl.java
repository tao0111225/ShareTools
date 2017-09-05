package com.shareTools.Test;

import com.shareTools.entity.UserEntity;
import com.shareTools.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserDaoServiceImpl extends BaseTest {

    @Autowired
    private UserService userService;


    @Test
    public void testService() throws  Exception{

        UserEntity userEntity= userService.queryById("admin","admin");

        System.out.println(userEntity.toString());

    }

}
