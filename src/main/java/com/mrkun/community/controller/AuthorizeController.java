package com.mrkun.community.controller;

import com.mrkun.community.dto.AccessTokenDTO;
import com.mrkun.community.dto.GithubUser;
import com.mrkun.community.mapper.UserMapper;
import com.mrkun.community.model.User;
import com.mrkun.community.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

/**
 * @author by liukun
 * @date 2020/3/4
 */
@Controller
public class AuthorizeController {
    @Autowired
    private GithubProvider githubProvider;

    @Value("${github.client.id}")
    private String clientId;

    @Value("${github.client.secret}")
    private String clientSecret;

    @Value("${github.redirect.uri}")
    private String clientUri;

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/callback")
    public String callback(@RequestParam(name="code")String code, @RequestParam(name="state")String state,
                           HttpServletRequest request){   //spring会自动把spring上下文中的HttpServletRequest放到这里面
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setClient_id(clientId);
        accessTokenDTO.setClient_secret(clientSecret);
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedirect_uri(clientUri);
        accessTokenDTO.setState(state);
        String accessToken = githubProvider.getAccessToken(accessTokenDTO);
        GithubUser githubUser = githubProvider.getUser(accessToken);
        System.out.println(githubUser);
        if (githubUser != null){
            User user = new User();
            user.setToken(UUID.randomUUID().toString());
            user.setAccountId(String.valueOf(githubUser.getId()));
            user.setGmtCreate(System.currentTimeMillis());
            user.setGmtModified(user.getGmtCreate());
            userMapper.insertUser(user);
            //登录成功，写cookie 和 session
            request.getSession().setAttribute("user",githubUser);
            return "redirect:/";
        }else {
            //登录失败
            return "redirect:/";
        }
    }

}
