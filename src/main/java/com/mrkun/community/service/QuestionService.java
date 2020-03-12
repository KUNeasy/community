package com.mrkun.community.service;

import com.mrkun.community.dto.PaginationDTO;
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

    public PaginationDTO list(Integer page, Integer size){
        //size*(page-1)
        Integer offset = size*(page-1);
        List<Question> list = questionMapper.list(offset,size);
        List<QuestionDTO> qList = new ArrayList<>();
        for (Question question:list) {
            User user = userMapper.findById(question.getCreator());
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question,questionDTO);
            questionDTO.setUser(user);
            qList.add(questionDTO);
        }
        PaginationDTO paginationDTO = new PaginationDTO();
        //总问题数
        Integer totalCount = questionMapper.count();
        //把问题加入分页
        paginationDTO.setQuestionDTOS(qList);
        //设置分页
        paginationDTO.setPagination(totalCount,page,size);
        return paginationDTO;
    }
}
