package com.example.finance.services;

import com.example.finance.models.BankAccount;
import com.example.finance.models.Income;
import com.example.finance.repositories.IncomeRepository;
import com.example.finance.repositories.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IncomeService {

    @Autowired
    private IncomeRepository incomeRepository;

    @Autowired
    private BankAccountRepository bankAccountRepository;

    public List<Income> getAllIncomes() {
        return incomeRepository.findAll();
    }

    public Income getIncomeById(Long id) {
        return incomeRepository.findById(id).orElseThrow(() -> new RuntimeException("Income not found"));
    }

    public Income createIncome(Income income) {
        BankAccount bankAccount = bankAccountRepository.findById(income.getBankAccount().getId())
                .orElseThrow(() -> new RuntimeException("BankAccount not found"));
        income.setBankAccount(bankAccount);
        return incomeRepository.save(income);
    }

    public Income updateIncome(Long id, Income income) {
        Income existingIncome = incomeRepository.findById(id).orElseThrow(() -> new RuntimeException("Income not found"));
        existingIncome.setSource(income.getSource());
        existingIncome.setAmount(income.getAmount());
        existingIncome.setDate(income.getDate());
        existingIncome.setBankAccount(income.getBankAccount());
        return incomeRepository.save(existingIncome);
    }

    public void deleteIncome(Long id) {
        incomeRepository.deleteById(id);
    }
}

