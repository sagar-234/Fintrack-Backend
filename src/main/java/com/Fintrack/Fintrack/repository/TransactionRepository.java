package com.Fintrack.Fintrack.repository;

import com.Fintrack.Fintrack.model.Transaction;
import com.Fintrack.Fintrack.model.TransactionType;
import com.Fintrack.Fintrack.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TransactionRepository extends JpaRepository<Transaction , Long> {

    List<Transaction> findByUser(User user);

    List<Transaction> findByUserAndType(User user, Transaction type);

    List<Transaction> findByUserAndCategory(User user, String category);




}
