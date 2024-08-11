package com.example.finance.services;

import com.example.finance.models.BankAccount;
import com.example.finance.repositories.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankAccountService {

    @Autowired
    private BankAccountRepository bankAccountRepository;

    public List<BankAccount> getAllBankAccounts() {
        return bankAccountRepository.findAll();
    }

    public BankAccount getBankAccountById(Long id) {
        return bankAccountRepository.findById(id).orElseThrow(() -> new RuntimeException("BankAccount not found"));
    }

    public BankAccount createBankAccount(BankAccount bankAccount) {
        return bankAccountRepository.save(bankAccount);
    }

    public BankAccount updateBankAccount(Long id, BankAccount bankAccount) {
        BankAccount existingBankAccount = bankAccountRepository.findById(id).orElseThrow(() -> new RuntimeException("BankAccount not found"));
        existingBankAccount.setBankName(bankAccount.getBankName());
        existingBankAccount.setAccountNumber(bankAccount.getAccountNumber());
        existingBankAccount.setBalance(bankAccount.getBalance());
        return bankAccountRepository.save(existingBankAccount);
    }

    public void deleteBankAccount(Long id) {
        bankAccountRepository.deleteById(id);
    }
}
