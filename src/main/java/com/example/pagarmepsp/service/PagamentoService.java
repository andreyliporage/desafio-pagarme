package com.example.pagarmepsp.service;

import com.example.pagarmepsp.domain.Payable;
import com.example.pagarmepsp.domain.PayableFactory;
import com.example.pagarmepsp.dto.TransactionRequest;
import com.example.pagarmepsp.repository.PayableRepository;
import com.example.pagarmepsp.repository.TransactionRepository;
import org.springframework.stereotype.Service;

@Service
public class PagamentoService {

    private final TransactionRepository transactionRepository;
    private final PayableRepository payableRepository;

    public PagamentoService(TransactionRepository transactionRepository, PayableRepository payableRepository) {
        this.transactionRepository = transactionRepository;
        this.payableRepository = payableRepository;
    }

    public Payable post(TransactionRequest request) {
        var transaction = request.toTransaction();
        transactionRepository.save(transaction);
        var payable = PayableFactory.criaPayable(transaction);

        return payableRepository.save(payable);
    }
}
