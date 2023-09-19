package com.myapp.board.service;

import com.myapp.board.common.Search;
import com.myapp.board.dao.BoardDAO;
import com.myapp.board.model.BoardVO;
import com.myapp.board.model.ReplyVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService{

    @Autowired
    private BoardDAO boardDAO;

    @Override
    public List<BoardVO> getBoardList(Search search) {
        return boardDAO.getBoardList(search);
    }

    @Override
    public int getBoardListCnt(Search search) {
        return boardDAO.getBoardListCnt(search);
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

    @Override
    public List<ReplyVO> getReplyList(int bid) {
        return boardDAO.getReplyList(bid);
    }

    @Override
    public int saveReply(ReplyVO replyVO) {
        return boardDAO.saveReply(replyVO);
    }

    @Override
    public int updateReply(ReplyVO replyVO) {
        return boardDAO.updateReply(replyVO);
    }

    @Override
    public int deleteReply(int rid) {
        return boardDAO.deleteReply(rid);
    }
}
