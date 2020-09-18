package com.fqy.service;

import com.fqy.pojo.Book;

import java.util.List;

public interface FindsBookService {

    List<Book> findBookAll();

    List<Book> findBookBycid(Integer cid);

}
