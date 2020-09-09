package com.qf.pojo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "admin_permission")
public class Permission {
    @Id
    private int id;
    private String name;
    @Column(name = "desc_")
    private String desc;
    private String url;
}
