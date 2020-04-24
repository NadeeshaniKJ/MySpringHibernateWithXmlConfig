package com.kanchi.controller;

import com.kanchi.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Locale;

@Controller
@RequestMapping(value = "/login")
public class UserController {

    private UserServiceImpl userService;

    @Autowired(required = true)
    public void setUserService(UserServiceImpl userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/count", method = RequestMethod.GET)
    public String home(Locale locale, Model model) {
        model.addAttribute("count",userService.getUserCount());
        return "userCount";
    }
}
