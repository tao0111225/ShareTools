package com.shareTools.web;


import com.shareTools.dto.Result;
import com.shareTools.entity.UserEntity;
import com.shareTools.service.UserService;

import com.shareTools.service.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/")
public class LoginController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    // TODO: 2017/9/5  记录 登录时间，请求日志.
    // 登录
    @RequestMapping(value = "login", method = RequestMethod.GET)
    @ResponseBody
    private Result<UserEntity> login() {
        String  UserName="admin";
        String  password="admin";
        if (StringUtils.isEmpty(UserName) || StringUtils.isEmpty(password)) {
            return new Result<>(false, "账号密码不能为空");
        }

        UserEntity userEntity = userService.queryById(UserName, password);

        if (userEntity == null) {
            return new Result<>(false, "请先注册");
        } else {
            return new Result<>(true, userEntity);
        }
    }

    // 注册
    @RequestMapping(value = "register", method = RequestMethod.GET)
    @ResponseBody
    private Result<UserEntity> register() {
        String  UserName="admin1";
        String  password="admin2";
        /**
         * 1 查询是否存储
         * 2 如果不存在，添加 返回对象
         * 3 如果存储 ，提示
         */
        if (StringUtils.isEmpty(UserName) || StringUtils.isEmpty(password)) {
            return new Result<>(false, "账号密码不能为空");
        }

        UserEntity userEntity = userService.queryById(UserName, password);

        // 注册 成功 返回对象
        if (userEntity == null) {
            UserEntity user=  userService.InsertUserResultObj(UserName,password);
            return new Result<>(true, user);
        } else {
            return new Result<>(false, "账号密码以及被注册");
        }
    }

}
