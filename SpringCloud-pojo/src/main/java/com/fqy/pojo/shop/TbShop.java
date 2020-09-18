package com.fqy.pojo.shop;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;


@Data
@Entity
@Table(name = "book")
public class TbShop {

    @Id
    private Integer id;

    private String title;

    private String cover;

    private String author;

    private String date;

    private String press;

    private String abs;

    private Integer cid;

    private Integer price;

    private Integer counts;
}
