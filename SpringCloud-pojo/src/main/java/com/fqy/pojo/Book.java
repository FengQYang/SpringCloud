package com.fqy.pojo;


import lombok.Data;

import java.util.Date;

@Data
public class Book {

    private Integer id;
    private String cover;
    private String title;
    private String author;
    private Date date;
    private String press;
    private String abs;
    private Integer cid;
    private Integer price;
    private Integer counts;
}
