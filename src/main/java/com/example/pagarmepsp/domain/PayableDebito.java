package com.example.pagarmepsp.domain;

import com.example.pagarmepsp.domain.enums.PayableStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class PayableDebito extends Payable {

    @Column(name = "status")
    private final PayableStatus status = PayableStatus.PAGO;

    @Column(name = "data_pagamento")
    private LocalDateTime dataPagamento;

    public PayableDebito() {
    }

    protected PayableDebito(Transaction transaction, LocalDateTime dataPagamento) {
        super(transaction);
        this.dataPagamento = dataPagamento;
    }

    public PayableStatus getStatus() {
        return status;
    }

    public LocalDateTime getDataPagamento() {
        return dataPagamento;
    }

    @Override
    public BigDecimal calculaSaldo() {
        var valorTransacao = getTransaction().getValor();
        var desconto = valorTransacao.multiply(BigDecimal.valueOf(getTaxa()));
        return valorTransacao.subtract(desconto);
    }

    @Override
    protected double getTaxa() {
        return 0.03;
    }
}
