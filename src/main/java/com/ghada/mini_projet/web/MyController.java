package com.ghada.mini_projet.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
public class MyController {
    @RequestMapping(value = "/")
    public String index(){

        return "index";

    }
}
