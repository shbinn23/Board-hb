package com.myapp.expense.dao;

import com.myapp.expense.model.ExpenseVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ExpenseDAO {

    List<ExpenseVO> getExpenseList(String userId);

    void addExpense(ExpenseVO expenseVO);
}
