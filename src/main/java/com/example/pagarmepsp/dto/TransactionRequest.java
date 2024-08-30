package com.example.pagarmepsp.dto;

import com.example.pagarmepsp.domain.Cartao;
import com.example.pagarmepsp.domain.Transaction;
import com.example.pagarmepsp.domain.enums.MetodoPagamento;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public record TransactionRequest(
        BigDecimal valor,
        String descricao,
        String numeroCartao,
        int metodoPagamento,
        String nomePortadorCartao,
        LocalDate dataValidadeCartao,
        String cvv
) {

    public Transaction toTransaction() {
        var cartao = new Cartao(numeroCartao, nomePortadorCartao, dataValidadeCartao, cvv);

        return new Transaction(
                descricao,
                valor,
                MetodoPagamento.getMetodoPagamento(metodoPagamento),
                cartao,
                LocalDateTime.now()
        );
    }
}
