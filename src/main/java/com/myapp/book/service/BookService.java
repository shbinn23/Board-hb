package com.myapp.book.service;

import com.myapp.book.model.BookVO;

import java.util.List;

public interface BookService {

    void insertBook(BookVO bookVO);

    List<BookVO> getBookList();
}
