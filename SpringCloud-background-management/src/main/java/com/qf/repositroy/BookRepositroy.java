package com.qf.repositroy;
import com.qf.pojo.Book;
import org.springframework.data.jpa.repository.JpaRepository;
public interface BookRepositroy extends  JpaRepository<Book,Integer>{
}
