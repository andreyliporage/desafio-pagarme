package com.example.pagarmepsp.service;

import com.example.pagarmepsp.dto.TransactionResponse;
import com.example.pagarmepsp.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionService {

    private final TransactionRepository repository;

    public TransactionService(TransactionRepository repository) {
        this.repository = repository;
    }

    public List<TransactionResponse> get() {
        var transactions = repository.findAll();

        List<TransactionResponse> response = new ArrayList<>();

        transactions.forEach(transaction -> response.add(TransactionResponse.fromTransaction(transaction)));

        return response;
    }
}
