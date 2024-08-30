package com.example.pagarmepsp.domain;

import com.example.pagarmepsp.domain.enums.MetodoPagamento;

import java.time.LocalDateTime;

public class PayableFactory {

    public static Payable criaPayable(Transaction transaction) {
        var metodoPagamento = transaction.getMetodoPagamento();
        var dataPagamento = LocalDateTime.now();

        return metodoPagamento == MetodoPagamento.DEBITO_CARD ? new PayableDebito(transaction, dataPagamento) : new PayableCredito(transaction, dataPagamento);
    }
}
