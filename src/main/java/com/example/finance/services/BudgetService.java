package com.example.finance.services;

import com.example.finance.models.Budget;
import com.example.finance.repositories.BudgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BudgetService {

    @Autowired
    private BudgetRepository budgetRepository;

    public List<Budget> getAllBudgets() {
        return budgetRepository.findAll();
    }

    public Budget getBudgetById(Long id) {
        return budgetRepository.findById(id).orElseThrow(() -> new RuntimeException("Budget not found"));
    }

    public Budget createBudget(Budget budget) {
        return budgetRepository.save(budget);
    }

    public Budget updateBudget(Long id, Budget budget) {
        Budget existingBudget = budgetRepository.findById(id).orElseThrow(() -> new RuntimeException("Budget not found"));
        existingBudget.setAmount(budget.getAmount());
        existingBudget.setStartDate(budget.getStartDate());
        existingBudget.setEndDate(budget.getEndDate());
        return budgetRepository.save(existingBudget);
    }

    public void deleteBudget(Long id) {
        budgetRepository.deleteById(id);
    }
}

