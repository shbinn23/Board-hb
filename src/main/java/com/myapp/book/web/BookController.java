package com.myapp.book.web;

import com.myapp.book.model.BookVO;
import com.myapp.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/bookForm")
    public String getBookForm(Model model) {
        // 기존 책 목록을 가져와서 모델에 추가
        List<BookVO> bookList = bookService.getBookList();
        model.addAttribute("bookList", bookList);

        // 새로운 책을 기록하기 위한 빈 BookVO 객체를 추가
        model.addAttribute("bookVO", new BookVO());

        return "book/bookForm";
    }

    @PostMapping("/recordBook")
    public String recordBook(BookVO bookVO, RedirectAttributes rttr, Model model) {
        try {
            // 서비스를 통해 책을 데이터베이스에 추가
            bookService.insertBook(bookVO);

            // 성공 메시지 또는 기록 성공에 대한 로직 추가
            rttr.addFlashAttribute("recordSuccess", true);
        } catch (Exception e) {
            // 예외 처리
            e.printStackTrace(); // 또는 예외를 로그에 기록
            // 에러 메시지를 플래시 속성에 추가하여 화면에 표시
            rttr.addFlashAttribute("recordError", true);
        }

        // 기록 후에도 기존 책 목록을 다시 가져와서 모델에 추가
        List<BookVO> bookList = bookService.getBookList();
        rttr.addFlashAttribute("bookList", bookList);

        return "redirect:/book/bookForm";
    }

    @GetMapping("/bookList")
    public String getBookList(Model model) {
        // 현재 책 목록을 가져와서 모델에 추가
        List<BookVO> bookList = bookService.getBookList();
        model.addAttribute("bookList", bookList);

        return "book/bookList";
    }
}
