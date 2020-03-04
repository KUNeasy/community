package com.mrkun.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author by liukun
 * @date 2020/3/4
 */
@Controller
public class IndexController {
    @GetMapping("/")
    public String index(){
        return "index";
    }

}
