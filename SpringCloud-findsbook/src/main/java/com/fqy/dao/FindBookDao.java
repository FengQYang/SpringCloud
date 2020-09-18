package com.fqy.dao;


import com.fqy.pojo.Book;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FindBookDao {

    List<Book> findBookAll();

    List<Book> findBookBycid(Integer cid);

}
