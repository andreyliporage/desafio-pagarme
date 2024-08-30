package com.example.pagarmepsp.controller;

import com.example.pagarmepsp.domain.Payable;
import com.example.pagarmepsp.domain.Transaction;
import com.example.pagarmepsp.dto.TransactionRequest;
import com.example.pagarmepsp.dto.TransactionResponse;
import com.example.pagarmepsp.service.PagamentoService;
import com.example.pagarmepsp.service.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    private final TransactionService transactionService;
    private final PagamentoService pagamentoService;

    public TransactionController(TransactionService transactionService, PagamentoService pagamentoService) {
        this.transactionService = transactionService;
        this.pagamentoService = pagamentoService;
    }

    @GetMapping
    public ResponseEntity<List<TransactionResponse>> get() {
        return ResponseEntity.ok(transactionService.get());
    }

    @PostMapping
    public ResponseEntity<Payable> post(@RequestBody TransactionRequest request) {
        var result = pagamentoService.post(request);

        return ResponseEntity.ok(result);
    }
}
