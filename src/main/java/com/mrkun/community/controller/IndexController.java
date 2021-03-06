package com.mrkun.community.controller;

import com.mrkun.community.dto.PaginationDTO;
import com.mrkun.community.dto.QuestionDTO;
import com.mrkun.community.mapper.UserMapper;
import com.mrkun.community.model.User;
import com.mrkun.community.service.QuestionService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @author by liukun
 * @date 2020/3/4
 */
@Controller
public class IndexController {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private QuestionService questionService;

    @GetMapping("/")
    public String index(HttpServletRequest request, Model model,
                        @RequestParam(value="page",defaultValue = "1")Integer page,
                        @RequestParam(value="size",defaultValue = "3")Integer size){
        //通过request可以获取到cookie数组，遍历找出名字是token的cookie，通过携带的token去数据库里找到用户
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
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
        }
        PaginationDTO paginationDTO = questionService.list(page,size);
        model.addAttribute("pages",paginationDTO);
        return "index";
    }

}
