package com.myapp.expense.service;

import com.myapp.expense.dao.ExpenseDAO;
import com.myapp.expense.model.ExpenseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    private final ExpenseDAO expenseDAO;

    @Autowired
    public ExpenseServiceImpl(ExpenseDAO expenseDAO) {
        this.expenseDAO = expenseDAO;
    }

    @Override
    public List<ExpenseVO> getExpenseList(String userId) {
        // Implement the logic to retrieve expense list by userId from the DAO
        return expenseDAO.getExpenseList(userId);
    }

    @Override
    public void addExpense(ExpenseVO expenseVO) {
        // Implement the logic to add an expense using the DAO
        expenseDAO.addExpense(expenseVO);
    }
}
