package com.board.service;

import com.board.dao.BoardDAO;
import com.board.model.BoardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
public class BoardServiceImpl implements BoardService{

    @Autowired
    private BoardDAO boardDAO;

    @Override
    public List<BoardVO> getBoardList() {
        return boardDAO.getBoardList();
    }

    @Override
    public int insertBoard(BoardVO boardVO) {
        String cateCd = "태그";
        boardVO.setCate_cd(cateCd);
        return boardDAO.insertBoard(boardVO);
    }

    @Override
    public BoardVO getBoardContent(int bid) {
        boardDAO.updateViewCnt(bid);
        return boardDAO.getBoardContent(bid);
    }

    @Override
    public void updateBoard(BoardVO boardVO) {
        String cateCd = "태그";
        boardVO.setCate_cd(cateCd);
        boardDAO.updateBoard(boardVO);
    }

    @Override
    public void deleteBoard(int bid) {
        boardDAO.deleteBoard(bid);
    }
}
