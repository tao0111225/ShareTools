package com.shareTools.service;

import com.shareTools.dao.UserDao;
import com.shareTools.entity.UserEntity;
import com.shareTools.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserService  implements UserServiceImpl{


    @Autowired
    UserDao userDao;


    @Override
    public UserEntity queryById(long id) {
        return null;
    }

    @Override
    public List<UserEntity> queryAll(int offset, int limit) {
        return null;
    }
}
