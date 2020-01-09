package com.example.demo.app.entity;

import com.example.demo.app.common.constant.UserType;
import lombok.Getter;
import lombok.Setter;

/**
 * description
 *
 * @author : jkkim
 */
@Getter
@Setter
public class AuthDto {

    private String userId;
    private String userNm;
    private String password;
    private String authKey;
    private UserType userType;
    private String useYn;

}
