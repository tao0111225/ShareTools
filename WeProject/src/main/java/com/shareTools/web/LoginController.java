package com.shareTools.web;


import com.shareTools.service.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/book")
public class LoginController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService bookService;


    @RequestMapping(value = "/list", method = RequestMethod.GET)
    private String list(Model model) {
        // list.jsp + model = ModelAndView
        return "list";// WEB-INF/jsp/"list".jsp
    }



}
