package com.board;

import com.board.dao.BoardDAO;
import com.board.model.BoardVO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.spi.LoggerFactoryBinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class BoardDaoTest {

    private static final Logger logger = LoggerFactory.getLogger(BoardDaoTest.class);

    @Autowired
    private BoardDAO boardDAO;

//    @Test
//    public void testGetBoardList() throws Exception {
//        // 게시판 목록 가져오기
//        List<BoardVO> boardList = boardDAO.getBoardList();
//
//        // 출력
//        System.out.println("\n Board List \n");
//
//        if (boardList.size() > 0) {
//            for (BoardVO board : boardList) {
//                System.out.println("Title: " + board.getTitle());
//            }
//        } else {
//            System.out.println("데이터가 없습니다.");
////            주석
//        }
//    }

    @Test
    public void testGetBoardContent() throws Exception {
        BoardVO boardVO = boardDAO.getBoardContent(1);

        System.out.println("\n Board List \n ");

        if (boardVO != null) {
            System.out.println("글번호 : " + boardVO.getBid());
            System.out.println("글제목 : " + boardVO.getTitle());
            System.out.println("글내용 : " + boardVO.getContent());
            System.out.println("글태그 : " + boardVO.getTag());
            System.out.println("조회수 : " + boardVO.getView_cnt());
            System.out.println("작성자 : " + boardVO.getReg_id());
            System.out.println("작성일 : " + boardVO.getReg_dt());
            System.out.println("수정일 : " + boardVO.getEdit_dt());
        } else {
            System.out.println("데이터가 없습니다.");
        }
    }

    @Test
    public void testInsertBoard() throws Exception {
        BoardVO boardVO = new BoardVO();
        boardVO.setCate_cd("1");
//        boardVO.setTitle("첫번째 게시물 입니다.");
//        boardVO.setContent("첫번째 게시물입니다.");
        boardVO.setTag("1");
        boardVO.setReg_id("1");

        for (int i = 0; i < 1234; i++) {
            boardVO.setTitle(i + " 번째 게시물입니다.");
            boardVO.setContent(i + " 번째 게시물입니다.");

            int result = boardDAO.insertBoard(boardVO);

            logger.info("\n Insert Board Result " + result);

            if (result == 1) {
                logger.info("\n게시물 등록 성공");
            } else {
                logger.info("\n게시물 등록 실패");
            }
        }

        int result = boardDAO.insertBoard(boardVO);

        System.out.println("\n Insert Board Result " + result);
        if (result == 1) {
            System.out.println("\n 게시물 등록 성공 ");
        } else {
            System.out.println("\n 게시물 등록 실패");
        }
    }

    @Test
    public void testUpdateBoard() throws Exception {
        BoardVO boardVO = new BoardVO();
        boardVO.setBid(1);
        boardVO.setCate_cd("1");
        boardVO.setTitle("첫번째 게시물 입니다-수정 합니다.");
        boardVO.setContent("첫번째 게시물입니다-수정합니다.");
        boardVO.setTag("1-1");
        int result = boardDAO.updateBoard(boardVO);

        System.out.println("\n Update Board Result \n ");
        if (result > 0) {
            System.out.println("\n 게시물 수정 성공 ");
        } else {
            System.out.println("\n 게시물 수정 실패");
        }
    }

    @Test
    public void testDeleteBoard() throws Exception {
        int result = boardDAO.deleteBoard(1);

        System.out.println("\n Delete Board Result \n ");
        if (result > 0) {
            System.out.println("\n 게시물 삭제 성공 ");
        } else {
            System.out.println("\n 게시물 삭제 실패");
        }
    }

    @Test
    public void testUpdateViewCnt() throws Exception {
        int result = boardDAO.updateViewCnt(1);

        System.out.println("\n Update View Count Result \n ");
        if (result > 0) {
            System.out.println("\n 게시물 조회수 업데이트 성공 ");
        } else {
            System.out.println("\n 게시물 조회수 업데이트 실패");
        }
    }


}