package com.auvgo.controller;

import com.auvgo.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/")
public class ListController {
    @Autowired
    private UserService userService;

    @RequestMapping("/list")
    public String sayHello(Model model){
//        model.addAttribute("mgs", "hello!!!");
        return "list";
    }
}
