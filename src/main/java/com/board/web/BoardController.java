package com.board.web;

import com.board.model.BoardVO;
import com.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping("/getBoardList")
    public String getBoardList(Model model) {
        model.addAttribute("boardList", boardService.getBoardList());
        return "board/index";
    }

    @GetMapping("/boardForm")
    public String boardForm() {
        return "board/boardForm";
    }

    @PostMapping("/insertBoard")
    public String insertBoard(@ModelAttribute("BoardVO") BoardVO boardVO, RedirectAttributes rttr) throws Exception {
        boardService.insertBoard(boardVO);
        return "redirect:/board/getBoardList";
    }

}