package com.mrkun.community.controller;

import com.mrkun.community.mapper.QuestionMapper;
import com.mrkun.community.mapper.UserMapper;
import com.mrkun.community.model.Question;
import com.mrkun.community.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;


/**
 * @author by liukun
 * @date 2020/3/5
 */
@Controller
public class PublishController {

    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/publish")
    public String publish(){
        return "publish";
    }

    @PostMapping("/publish")
    public String doQuestion(
            @RequestParam(value="title") String title,
            @RequestParam(value="description") String description,
            @RequestParam(value="tag") String tag,
            HttpServletRequest request,
            Model model){
        model.addAttribute("title",title);
        model.addAttribute("description",description);
        model.addAttribute("tag",tag);
        if (title == null || "".equals(title) ){
            model.addAttribute("error","标题不能为空");
            return "publish";
        }
        if (description == null || "".equals(description)){
            model.addAttribute("error","问题不能为空");
            return "publish";
        }
        if (tag == null || "".equals(tag)){
            model.addAttribute("error","标签不能为空");
            return "publish";
        }
        User user = null;
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if ("token".equals(cookie.getName())){
                String token = cookie.getValue();
                user = userMapper.findByToken(token);
                if(user != null){
                    //把user放到session里
                    request.getSession().setAttribute("user",user);
                }
                break;
            }
        }
        if (user == null){
            model.addAttribute("error","用户未登录");
            return "publish";
        }
        
        Question question = new Question();
        question.setTitle(title);
        question.setDescription(description);
        question.setTag(tag);
        question.setCreator(user.getId());
        question.setGmtCreate(System.currentTimeMillis());
        question.setGmtModified(question.getGmtCreate());
        questionMapper.insertQuestion(question);

        return "redirect:/";
    }


}
