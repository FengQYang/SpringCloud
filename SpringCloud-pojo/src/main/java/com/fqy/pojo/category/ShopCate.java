package com.fqy.pojo.category;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "category")
public class ShopCate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
}
