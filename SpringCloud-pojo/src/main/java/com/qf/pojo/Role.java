package com.qf.pojo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "admin_role")
public class Role {
    @Id
    private int id;
    private String name;
    @Column(name = "name_zh")
    private String nameZh;
    private int enabled;
}
