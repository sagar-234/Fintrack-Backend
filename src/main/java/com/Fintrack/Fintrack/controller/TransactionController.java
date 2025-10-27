package com.Fintrack.Fintrack.controller;


import com.Fintrack.Fintrack.model.Transaction;
import com.Fintrack.Fintrack.repository.TransactionRepository;
import com.Fintrack.Fintrack.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transaction")

public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PutMapping("/{Id}")
    public Transaction updateTransaction(@PathVariable("Id") Long TransactionId, @RequestBody Transaction transaction){
        return transactionService.updateTransaction(TransactionId, transaction);
    }

    @PostMapping
    public Transaction createTransaction( @RequestBody Transaction transaction){
        return transactionService.createTransaction(transaction);
    }

    @GetMapping
    public List<Transaction> getAllTransactions(){
        return transactionService.getAllTransactions();
    }


    @GetMapping("getTransactionById/{TransactionId}")
    public Transaction getTransactionById(@PathVariable Long TransactionId){
        return transactionService.getTransactionById(TransactionId);
    }

    @DeleteMapping("delete/{TransactionId}")
    public String deleteTransaction(@PathVariable Long TransactionId){
        transactionService.deleteTransaction(TransactionId);
        return ("transaction deleted successfully");
    }



}
