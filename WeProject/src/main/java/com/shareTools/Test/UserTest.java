package com.shareTools.Test;

import com.shareTools.dao.UserDao;
import com.shareTools.entity.UserEntity;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

public class UserTest extends BaseTest {

    @Autowired
    UserDao userDao;

    @Test
    public void testAppoint() throws Exception {
        UserEntity userEntity=new UserEntity();
        userEntity.setUserName("jk");
        userEntity.setPassword("123456");
        userEntity.setCreateTime(new Date());
        userEntity.setUpdateTime(new Date());
     int ok=   userDao.insertUser(userEntity);
        System.out.println(ok);
    }

}
