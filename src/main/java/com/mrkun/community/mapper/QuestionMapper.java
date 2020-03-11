package com.mrkun.community.mapper;

import com.mrkun.community.model.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author by liukun
 * @date 2020/3/5
 */
@Mapper
public interface QuestionMapper {
    @Insert("insert into question (title,description,tag,gmt_create,gmt_modified,creator) values (#{title},#{description},#{tag},#{gmtCreate},#{gmtModified},#{creator})")
    void insertQuestion(Question question);

    @Select("select * from question")
    List<Question> list();
}
