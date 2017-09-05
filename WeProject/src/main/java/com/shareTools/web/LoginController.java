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
@RequestMapping("/login")
public class LoginController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    // 登录
    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    private Result<UserEntity> login(@RequestParam("UserName") String UserName, @RequestParam("password") String password) {

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

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    @ResponseBody
    private Result<UserEntity> register(@RequestParam("UserName") String UserName, @RequestParam("password") String password) {

        /**
         * 1 查询是否存储
         * 2 如果不存在，添加 返回对象
         * 3 如果存储 ，提示
         */
        if (StringUtils.isEmpty(UserName) || StringUtils.isEmpty(password)) {
            return new Result<>(false, "账号密码不能为空");
        }

        UserEntity userEntity = userService.queryById(UserName, password);

        if (userEntity == null) {
            userService.InsertUser(UserName,password);
        } else {
            return new Result<>(false, "账号密码以及被注册");
        }

        return null;
    }

}
