package com.myapp.expense.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class ExpenseVO {

    private int id;
    private BigDecimal amount;
    private String description;
    private String category;
    private LocalDate recordDate;
    private String userId;

    // getters and setters
}
