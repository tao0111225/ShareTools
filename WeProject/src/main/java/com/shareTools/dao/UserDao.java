package com.shareTools.dao;

import com.shareTools.entity.UserEntity;

public interface UserDao {

    /**
     *  新建用户
     */
    int insertUser(UserEntity userEntity);

}
