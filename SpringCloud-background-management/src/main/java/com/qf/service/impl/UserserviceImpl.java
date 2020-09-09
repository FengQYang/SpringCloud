package com.qf.service.impl;

import com.qf.pojo.User;
import com.qf.repositroy.UserRepositroy;
import com.qf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserserviceImpl implements UserService {

    @Autowired
    UserRepositroy userRepositroy;

    @Override
    public List<User> findAll() {
        return userRepositroy.findAll();
    }
}
