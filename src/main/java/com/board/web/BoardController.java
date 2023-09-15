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

    /**
     * 게시글 리스트를 조회합니다.
     *
     * @param model 모델 객체
     * @return 게시글 리스트 뷰 페이지 이름
     */
    @GetMapping("/getBoardList")
    public String getBoardList(Model model) {
        model.addAttribute("boardList", boardService.getBoardList());
        return "board/index";
    }

    /**
     * 글 작성 페이지를 불러옵니다.
     *
     * @param vo    BoardVO 객체
     * @param model 모델 객체
     * @return 글 작성 페이지 뷰 페이지 이름
     */
    @GetMapping("/writeForm")
    public String writeForm(@ModelAttribute("boardVO") BoardVO vo, Model model) {
        return "board/writeForm";
    }

    /**
     * 게시글을 저장하거나 수정합니다.
     *
     * @param boardVO      BoardVO 객체
     * @param mode         작업 모드 (edit 또는 insert)
     * @param rttr         RedirectAttributes 객체
     * @return 게시글 리스트 페이지로 리다이렉트
     * @throws Exception 예외 처리
     */
    @PostMapping("/saveBoard")
    public String saveBoard(@ModelAttribute("boardVO") BoardVO boardVO,
                            @RequestParam("mode") String mode,
                            RedirectAttributes rttr) throws Exception {
        if (mode.equals("edit")) {
            boardService.updateBoard(boardVO);
        } else {
            boardService.insertBoard(boardVO);
        }
        return "redirect:/board/getBoardList";
    }

    /**
     * 게시글 내용을 조회합니다.
     *
     * @param model 모델 객체
     * @param bid   게시글 ID
     * @return 게시글 내용 뷰 페이지 이름
     * @throws Exception 예외 처리
     */
    @RequestMapping(value = "/getBoardContent", method = RequestMethod.GET)
    public String getBoardContent(Model model, @RequestParam("bid") int bid) throws Exception {
        model.addAttribute("boardContent", boardService.getBoardContent(bid));
        return "board/boardContent";
    }

    /**
     * 글 수정 페이지를 불러옵니다.
     *
     * @param bid   게시글 ID
     * @param mode  작업 모드 (edit 또는 insert)
     * @param model 모델 객체
     * @return 글 작성 페이지 뷰 페이지 이름
     * @throws Exception 예외 처리
     */
    @RequestMapping(value = "/editForm", method = RequestMethod.GET)
    public String editForm(@RequestParam("bid") int bid,
                           @RequestParam("mode") String mode,
                           Model model) throws Exception {
        model.addAttribute("boardContent", boardService.getBoardContent(bid));
        model.addAttribute("mode", mode);
        model.addAttribute("boardVO", new BoardVO());
        return "board/boardForm";
    }

    /**
     * 게시글을 삭제합니다.
     *
     * @param rttr RedirectAttributes 객체
     * @param bid  게시글 ID
     * @return 게시글 리스트 페이지로 리다이렉트
     * @throws Exception 예외 처리
     */
    @RequestMapping(value = "/deleteBoard", method = RequestMethod.GET)
    public String deleteBoard(RedirectAttributes rttr, @RequestParam("bid") int bid) throws Exception {
        boardService.deleteBoard(bid);
        return "redirect:/board/getBoardList";
    }
}
