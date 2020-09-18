package com.fqy.controller;


import com.fqy.pojo.Book;
import com.fqy.service.FindsBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FindsBookController {

    @Autowired
    FindsBookService findsBookService;

    @RequestMapping("/findAll")
    public List<Book> findALll(){
        return  findsBookService.findBookAll();
    }

    @RequestMapping("/findBookBycid/{cid}")
    public List<Book> findALll(@PathVariable("cid") Integer cid){
        return  findsBookService.findBookBycid(cid);
    }
}
