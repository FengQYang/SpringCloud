package com.qf.pojo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
public class Book {
    @Id
    private int id;
    private String cover;
    private String title;
    private String author;
    private Date date;
    private String press;
    private String abs;


}
