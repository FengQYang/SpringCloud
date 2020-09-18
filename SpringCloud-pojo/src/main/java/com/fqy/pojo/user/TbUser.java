package com.fqy.pojo.user;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "user")
public class TbUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "username")
    private String username;

    private String password;

    private String salt;

    private String name;

    private String phone;

    private String email;

    private double enabled;
}
