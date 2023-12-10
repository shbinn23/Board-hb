package com.myapp.book.service;

import com.myapp.book.dao.BookDAO;
import com.myapp.book.model.BookVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDAO bookDAO;

    @Override
    public void insertBook(BookVO bookVO) {
        bookDAO.insertBook(bookVO);
    }

    @Override
    public List<BookVO> getBookList() {
        return bookDAO.getBookList();
    }
}
