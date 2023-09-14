package com.board.service;

import com.board.model.BoardVO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BoardService {

    public List<BoardVO> getBoardList();
}
