package com.fqy.service.impl;

import com.fqy.dao.FindBookDao;
import com.fqy.pojo.Book;
import com.fqy.service.FindsBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindsBookServiceImpl  implements FindsBookService {

    @Autowired
    FindBookDao findBookDao;

    @Override
    public List<Book> findBookAll() {
        return findBookDao.findBookAll();
    }

    @Override
    public List<Book> findBookBycid(Integer cid) {
        return findBookDao.findBookBycid(cid);
    }
}
