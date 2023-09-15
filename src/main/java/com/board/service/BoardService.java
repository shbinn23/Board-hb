package com.board.service;

import com.board.model.BoardVO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
public interface BoardService {

    public List<BoardVO> getBoardList();

    public int insertBoard(BoardVO boardVO);
}
