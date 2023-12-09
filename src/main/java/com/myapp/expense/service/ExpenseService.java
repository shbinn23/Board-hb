package com.myapp.expense.service;

import com.myapp.expense.model.ExpenseVO;

import java.util.List;

public interface ExpenseService {

    List<ExpenseVO> getExpenseList(String userId);

    void addExpense(ExpenseVO expenseVO);
}
