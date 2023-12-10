package com.myapp.book.dao;

import com.myapp.book.model.BookVO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BookDAO {

    List<BookVO> getBookList();

    void insertBook(BookVO bookVO);
}
