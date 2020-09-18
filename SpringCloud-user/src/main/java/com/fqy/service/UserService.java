package com.fqy.service;

import com.fqy.pojo.user.TbUser;
import com.fqy.pojo.user.UserReq;

public interface UserService {

    String login(TbUser tbUser);
    String sendMail(String s);
    String registry(UserReq  userReq);
}
