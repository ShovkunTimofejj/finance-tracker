package com.example.finance.controllers;


import com.example.finance.models.Income;
import com.example.finance.services.IncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/incomes")
public class IncomeController {

    @Autowired
    private IncomeService incomeService;

    @GetMapping
    public List<Income> getAllIncomes() {
        return incomeService.getAllIncomes();
    }

    @GetMapping("/{id}")
    public Income getIncomeById(@PathVariable long id) {
        return incomeService.getIncomeById(id);
    }

    @PostMapping
    public Income createIncome(@RequestBody Income income) {
        return incomeService.createIncome(income);
    }

    @PutMapping("/{id}")
    public Income updateIncome(@PathVariable long id, @RequestBody Income income) {
        return incomeService.updateIncome(id, income);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIncome(@PathVariable long id) {
        incomeService.deleteIncome(id);
        return ResponseEntity.noContent().build();
    }
}
