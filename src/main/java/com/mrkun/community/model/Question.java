package com.mrkun.community.model;

import lombok.Data;

/**
 * @author by liukun
 * @date 2020/3/5
 */
@Data
public class Question {
    private Integer id;
    private String title;
    private String description;
    private String tag;
    private Long gmtCreate;
    private Long gmtModified;
    private Integer commentCount;
    private Integer viewCount;
    private Integer likeCount;
}
