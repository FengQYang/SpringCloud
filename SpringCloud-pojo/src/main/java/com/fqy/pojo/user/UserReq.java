package com.fqy.pojo.user;

import lombok.Data;

@Data
public class UserReq {

    private String username;

    private String password;

    private String code;

    private String email;
}
