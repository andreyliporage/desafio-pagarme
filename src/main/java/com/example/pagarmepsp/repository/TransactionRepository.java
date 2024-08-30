package com.example.pagarmepsp.repository;

import com.example.pagarmepsp.domain.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
