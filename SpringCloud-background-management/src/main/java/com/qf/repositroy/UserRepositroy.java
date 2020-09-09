package com.qf.repositroy;

import com.qf.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositroy extends JpaRepository<User,Integer> {
}
