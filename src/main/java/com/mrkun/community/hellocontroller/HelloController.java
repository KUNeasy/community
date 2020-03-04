package com.mrkun.community.hellocontroller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author by liukun
 * @date 2020/3/4
 */
@Controller
public class HelloController {
    @GetMapping("/hello")
    public String hello(@RequestParam(value="name")String name, Model model){
        model.addAttribute("name",name);
        return "hello";
    }

}
