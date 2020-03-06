package com.mrkun.community.dto;

import lombok.Data;

/**
 * @author by liukun
 * @date 2020/3/4
 */
@Data
public class GithubUser {
    private String name;
    private Long id;
    private String bio;
    private String avatar_url;
}
