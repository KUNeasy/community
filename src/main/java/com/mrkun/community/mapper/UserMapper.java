package com.mrkun.community.mapper;

import com.mrkun.community.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author by liukun
 * @date 2020/3/4
 */
@Mapper
public interface UserMapper {
    @Insert("insert into User (account_id,name,token,gmt_create,gmt_modified) values (#{accountId},#{name},#{token},#{gmtCreate},#{gmtModified})")
    void insertUser(User user);
}
