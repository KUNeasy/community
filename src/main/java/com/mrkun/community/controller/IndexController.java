package com.mrkun.community.controller;

import com.mrkun.community.mapper.UserMapper;
import com.mrkun.community.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @author by liukun
 * @date 2020/3/4
 */
@Controller
public class IndexController {
    @Autowired
    private UserMapper userMapper;

    @GetMapping("/")
    public String index(HttpServletRequest request){
        //通过request可以获取到cookie数组，遍历找出名字是token的cookie，通过携带的token去数据库里找到用户
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if ("token".equals(cookie.getName())){
                String token = cookie.getValue();
                User user = userMapper.findByToken(token);
                if(user != null){
                    //把user放到session里
                    request.getSession().setAttribute("user",user);
                }
                break;
            }
        }

        return "index";
    }

}
