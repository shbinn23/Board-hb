package com.board.web;

import com.board.model.BoardVO;
import com.board.service.BoardService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Map;

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

    @RequestMapping("/boardForm")

    public String boardForm() {

        return "board/boardForm";

    }

    @RequestMapping(value = "/saveBoard", method = RequestMethod.POST)

    public String saveBoard(@ModelAttribute("boardVO") BoardVO boardVO

            , @RequestParam("mode") String mode

            , RedirectAttributes rttr) throws Exception {



        if (mode.equals("edit")) {

            boardService.updateBoard(boardVO);

        } else {

            boardService.insertBoard(boardVO);

        }



        return "redirect:/board/getBoardList";

    }

    @GetMapping("/getBoardContent")
    public String getBoardContent(Model model, @RequestParam("bid") int bid) throws Exception {
        model.addAttribute("boardContent", boardService.getBoardContent(bid)); // boardContent를 model에 추가
        return "board/boardContent";
    }

    @RequestMapping(value = "/editForm", method = RequestMethod.GET)

    public String editForm(@RequestParam("bid") int bid

            , @RequestParam("mode") String mode, Model model) throws Exception {

        model.addAttribute("boardContent", boardService.getBoardContent(bid));

        model.addAttribute("mode", mode);

        model.addAttribute("boardVO", new BoardVO());

        return "board/boardForm";

    }

    @RequestMapping(value = "/deleteBoard", method = RequestMethod.GET)

    public String deleteBoard(RedirectAttributes rttr, @RequestParam("bid") int bid) throws Exception {

        boardService.deleteBoard(bid);

        return "redirect:/board/getBoardList";

    }
}