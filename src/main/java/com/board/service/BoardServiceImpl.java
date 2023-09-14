package com.board.service;

import com.board.dao.BoardDAO;
import com.board.model.BoardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService{

    @Autowired
    private BoardDAO boardDAO;

    @Override
    public List<BoardVO> getBoardList() {
        return boardDAO.getBoardList();
    }
}
