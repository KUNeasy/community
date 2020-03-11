package com.mrkun.community.dto;

import com.mrkun.community.model.User;
import lombok.Data;

/**
 * @author by liukun
 * @date 2020/3/11
 */
@Data
public class QuestionDTO {
    private Integer id;
    private String title;
    private String description;
    private String tag;
    private Long gmtCreate;
    private Long gmtModified;
    private Integer commentCount;
    private Integer viewCount;
    private Integer likeCount;
    private User user;
}
