package com.shareTools.dao;

import com.shareTools.entity.UserEntity;

public interface UserDao {

    /**
     *  新建用户
     */
    Long InsertUserResultObj(UserEntity userEntity);


    /**
     *  查询单个用户
     */
    UserEntity queryById(String name,String password);





}
