package com.myapp.book.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookVO {

    private Long id;
    private String title;
    private String author;
    private String description;  // 추가
    private int rating;
    private String createdAt;

    // getters and setters
}
