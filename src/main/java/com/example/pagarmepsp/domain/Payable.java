package com.example.pagarmepsp.domain;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "tb_payable")
public abstract class Payable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @ManyToOne
    protected Transaction transaction;

    public Payable() {
    }

    public Payable(Transaction transaction) {
        this.transaction = transaction;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public abstract BigDecimal calculaSaldo();
    protected abstract double getTaxa();
}
