package com.mrkun.community.service;

import com.mrkun.community.dto.QuestionDTO;
import com.mrkun.community.mapper.QuestionMapper;
import com.mrkun.community.mapper.UserMapper;
import com.mrkun.community.model.Question;
import com.mrkun.community.model.User;
import org.h2.util.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author by liukun
 * @date 2020/3/11
 */
@Service
public class QuestionService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private QuestionMapper questionMapper;

    public List<QuestionDTO> list(){
        List<Question> list = questionMapper.list();
        List<QuestionDTO> qList = new ArrayList<>();
        for (Question question:list) {
            User user = userMapper.findById(question.getCreator());
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question,questionDTO);
            questionDTO.setUser(user);
            qList.add(questionDTO);
        }
        return qList;
    }
}
