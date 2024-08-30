package com.example.pagarmepsp.dto;

import com.example.pagarmepsp.domain.Transaction;
import com.example.pagarmepsp.domain.enums.MetodoPagamento;

import java.math.BigDecimal;
import java.time.LocalDate;

public record TransactionResponse(
        LocalDate dataTransacao,
        String descricao,
        MetodoPagamento metodoPagamento,
        BigDecimal valor
) {

    public static TransactionResponse fromTransaction(Transaction transaction) {
        return new TransactionResponse(
                transaction.getCriadoEm().toLocalDate(),
                transaction.getDescricao(),
                transaction.getMetodoPagamento(),
                transaction.getValor()
        );
    }
}
