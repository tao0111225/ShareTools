package com.shareTools.service;

import com.shareTools.dao.UserDao;
import com.shareTools.entity.UserEntity;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements  UserService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
   private UserDao userDao;


    @Override
    public UserEntity queryById(long id) {

        return null;
    }

    @Override
    public UserEntity queryById(String name, String password) {

        UserEntity userEntity=userDao.queryById(name,password);
       if ( userEntity==null){
           return null;
       }else {
           return  userEntity;
       }

    }



}
