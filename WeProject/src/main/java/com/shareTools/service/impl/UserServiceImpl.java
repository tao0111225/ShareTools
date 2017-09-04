package com.shareTools.service.impl;

import com.shareTools.entity.UserEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserServiceImpl {

    /**
     * 通过ID查询用户想去
     *
     * @param id
     * @return
     */
    UserEntity queryById(long id);

    /**
     * 查询所有用户
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return
     */
    List<UserEntity> queryAll(@Param("offset") int offset, @Param("limit") int limit);


}
