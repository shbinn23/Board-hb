package com.board.dao;

import com.board.common.Pagination;
import com.board.common.Search;
import com.board.model.BoardVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardDAO {

    /**
     * 게시판 목록 조회 메서드
     * @return 게시판 목록
     */
    public List<BoardVO> getBoardList(Search search);

    /**
     * 총 게시글 개수 확인
     * @return
     * @throws Exception
     */
    public int getBoardListCnt(Search search);

    /**
     * 게시글 내용 조회 메서드
     * @param bid 게시글 번호
     * @return 게시글 내용
     */
    public BoardVO getBoardContent(int bid);

    /**
     * 게시글 추가 메서드
     * @param boardVO 추가할 게시글 정보
     * @return 추가된 게시글 수
     */
    public int insertBoard(BoardVO boardVO);

    /**
     * 게시글 수정 메서드
     * @param boardVO 수정할 게시글 정보
     * @return 수정된 게시글 수
     */
    public int updateBoard(BoardVO boardVO);

    /**
     * 게시글 삭제 메서드
     * @param bid 삭제할 게시글 번호
     * @return 삭제된 게시글 수
     */
    public int deleteBoard(int bid);

    /**
     * 조회수 업데이트 메서드
     * @param bid 게시글 번호
     * @return 업데이트된 조회수
     */
    public int updateViewCnt(int bid);

}
