package com.auvgo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/")
public class HelloController {

    @RequestMapping("/hello")
    public String sayHello(Model model){
        model.addAttribute("mgs", "hello!!!");
        return "hello";
    }
}
