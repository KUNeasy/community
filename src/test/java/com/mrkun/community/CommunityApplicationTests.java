package com.mrkun.community;

import com.mrkun.community.mapper.QuestionMapper;
import com.mrkun.community.model.Question;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CommunityApplicationTests {

    @Autowired
    private QuestionMapper questionMapper;

    @Test
    void contextLoads() {
    }

    @Test
    void textQuestion(){
        Question question = new Question();
        question.setTitle("测试");
        question.setDescription("测试");
        question.setTag("测试");
        questionMapper.insertQuestion(question);
    }

    @Test
    void testInteger(){
        System.out.println(3/2);
    }
}
