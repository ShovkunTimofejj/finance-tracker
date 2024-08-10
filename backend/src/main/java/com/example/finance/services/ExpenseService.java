package com.example.finance.services;

import com.example.finance.models.Expense;
import com.example.finance.repositories.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }

    public Expense getExpenseById(long id) {
        return expenseRepository.findById(id).orElse(null);
    }

    public Expense saveExpense(Expense expense) {
        return expenseRepository.save(expense);
    }

    public Expense updateExpense(long id, Expense expenseDetails) {
        Expense existingExpense = getExpenseById(id);
        if (existingExpense != null) {
            existingExpense.setDescription(expenseDetails.getDescription());
            existingExpense.setAmount(expenseDetails.getAmount());
            existingExpense.setDate(expenseDetails.getDate());
            existingExpense.setBankAccount(expenseDetails.getBankAccount());
            existingExpense.setCategory(expenseDetails.getCategory());  // Установка категории
            return expenseRepository.save(existingExpense);
        } else {
            return null;
        }
    }

    public boolean deleteExpense(long id) {
        Expense existingExpense = getExpenseById(id);
        if (existingExpense != null) {
            expenseRepository.delete(existingExpense);
            return true;
        } else {
            return false;
        }
    }
}




