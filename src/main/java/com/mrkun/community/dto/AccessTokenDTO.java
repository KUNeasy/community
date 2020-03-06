package com.mrkun.community.dto;

import lombok.Data;

/**
 * @author by liukun
 * @date 2020/3/4
 */
@Data
public class AccessTokenDTO {
    private String client_id;
    private String client_secret;
    private String code;
    private String redirect_uri;
    private String state;

}
