package com.mrkun.community.mapper;

import com.mrkun.community.model.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author by liukun
 * @date 2020/3/5
 */
@Mapper
public interface QuestionMapper {
    @Insert("insert into question (title,description,tag,gmt_create,gmt_modified) values (#{title},#{description},#{tag},#{gmtCreate},#{gmtModified})")
    void insertQuestion(Question question);
}
