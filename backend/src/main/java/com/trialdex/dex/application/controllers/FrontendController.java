package com.trialdex.dex.application.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FrontendController {

    @RequestMapping(path = {"/"})
    public String index() {
        return "forward:/index.html";
    }

    @RequestMapping(path = {"/login"})
    public String login() {
        return "forward:/";
    }

    @RequestMapping("favicon.ico")
    String favicon() {
        return "forward:/";
    }

    @RequestMapping(path = {"/trials/**"})
    public String trials() {
        return "forward:/";
    }

    @RequestMapping(path = {"/subjects/**"})
    public String subjects() {
        return "forward:/";
    }
}
