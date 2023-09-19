package com.myapp.board.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ReplyVO {
    private int rid;
    private int bid;
    private String content;
    private String reg_id;
    private String reg_dt;
    private String edit_dt;

    // Getter와 Setter 메서드

    // 필요한 생성자

    // 기타 필요한 메서드
}