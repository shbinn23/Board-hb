package com.board.service;

import com.board.common.Pagination;
import com.board.common.Search;
import com.board.model.BoardVO;
import com.board.model.ReplyVO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
public interface BoardService {

    public List<BoardVO> getBoardList(Search search);

    public int getBoardListCnt(Search search);

    public int insertBoard(BoardVO boardVO);

    public BoardVO getBoardContent(int bid);

    public void updateBoard(BoardVO boardVO);

    public void deleteBoard(int bid);

    // 댓글 리스트

    public List<ReplyVO> getReplyList(int bid);

    public int saveReply(ReplyVO replyVO);

    public int updateReply(ReplyVO replyVO);

    public int deleteReply(int rid);
}
