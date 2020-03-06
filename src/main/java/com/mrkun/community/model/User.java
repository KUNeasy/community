package com.mrkun.community.model;

import lombok.Data;

/**
 * @author by liukun
 * @date 2020/3/4
 */
@Data
public class User {
    private Integer id;
    private String accountId;
    private String name;
    private String token;
    private Long gmtCreate;
    private Long gmtModified;
    private String avatarUrl;
}
