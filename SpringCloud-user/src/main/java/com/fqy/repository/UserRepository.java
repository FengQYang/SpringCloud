package com.fqy.repository;

import com.fqy.pojo.user.TbUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<TbUser,Integer> {

    //findBy+查询字段+and+查询字段；
    TbUser findByUsername(String username);

}
