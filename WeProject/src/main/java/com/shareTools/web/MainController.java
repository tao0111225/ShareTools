package com.shareTools.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/")
public class MainController {



    // todo  达到jsp 主动请求 后端
    @RequestMapping(value = "main", method = RequestMethod.GET)
    public String GoMain(){

        // 一级目录




        return "Main";
    }
}
