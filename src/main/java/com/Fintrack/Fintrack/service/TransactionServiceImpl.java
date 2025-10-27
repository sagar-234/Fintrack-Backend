package com.Fintrack.Fintrack.service;


import com.Fintrack.Fintrack.model.Transaction;
import com.Fintrack.Fintrack.model.User;
import com.Fintrack.Fintrack.repository.TransactionRepository;
import com.Fintrack.Fintrack.repository.UserRepository;
import jakarta.transaction.Transactional;



import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;


@Slf4j

@Service
public class TransactionServiceImpl implements TransactionService {

@Autowired
    private TransactionRepository transactionRepository;
@Autowired
    private  UserRepository userRepository;


    @Override
    public Transaction createTransaction(Transaction transaction) {
    return  transactionRepository.save(transaction);
    }

    @Override
    public Transaction getTransactionById(Long TransactionId) {
        return transactionRepository.findById(TransactionId)
                .orElseThrow(() -> new RuntimeException("Transaction not found with id" + TransactionId));
    }

    @Override
    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }


    @Override
    @Transactional
    public Transaction updateTransaction(Long TransactionId, Transaction transaction) {
        Transaction existing = transactionRepository.findById(TransactionId).
                orElseThrow(() -> new RuntimeException("transaction does not exists for id "+ TransactionId));

        if (transaction.getAmount() != null)
            existing.setAmount(transaction.getAmount());

        if (transaction.getCategory() != null)
            existing.setCategory(transaction.getCategory());

        if (transaction.getType() != null)
            existing.setType(transaction.getType());

        if (transaction.getDescription() != null)
            existing.setDescription(transaction.getDescription());

        if (transaction.getUser() != null && transaction.getUser().getId() != null) {
            User user = userRepository.findById(transaction.getUser().getId())
                    .orElseThrow(() -> new RuntimeException("User not found"));
            existing.setUser(user);
        }
        // 4️⃣ Force Hibernate to persist changes immediately
        existing = transactionRepository.save(existing);
        transactionRepository.flush();
     return existing;


    }

    @Override
    public void deleteTransaction(Long TransactionId) {
        if (!transactionRepository.existsById(TransactionId))
            throw new RuntimeException("transaction with this id does not exists" + TransactionId);
      transactionRepository.deleteById(TransactionId);
    }

    @Override
    public List<Transaction> getTransactionByUserId(Long userid) {
        return List.of();
    }

    @Override
    public List<Transaction> getTransactionByDateRange(LocalDate startDate, LocalDate endaDate) {
        return List.of();
    }

    @Override
    public Double getTotalAmountById(Long userid) {
        return 0.0;
    }
}
