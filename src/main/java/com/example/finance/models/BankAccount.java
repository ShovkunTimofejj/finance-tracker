package com.example.finance.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@Entity
public class BankAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String bankName;
    private String accountNumber;
    private BigDecimal balance;

    @OneToMany(mappedBy = "bankAccount")
    private List<Income> incomes;

    @OneToMany(mappedBy = "bankAccount")
    private List<Expense> expenses;

}


