package com.shareTools.service;


import com.shareTools.entity.UserEntity;


public interface UserService   {


    /**
     * 通过ID查询用户想去
     *
     * @param id
     * @return
     */
    UserEntity queryById(long id);


    UserEntity queryById(String name,String password);


}
