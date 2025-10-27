package com.Fintrack.Fintrack.service;

import com.Fintrack.Fintrack.model.Transaction;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public interface TransactionService {



Transaction createTransaction(Transaction transaction);

Transaction getTransactionById(Long TransactionId);

List<Transaction> getAllTransactions();

Transaction updateTransaction(Long TransactionId, Transaction transaction);

void deleteTransaction(Long TransactionId);

 List<Transaction> getTransactionByUserId(Long userid);

 List<Transaction> getTransactionByDateRange(LocalDate startDate, LocalDate endaDate);

 Double getTotalAmountById(Long userid);




}
