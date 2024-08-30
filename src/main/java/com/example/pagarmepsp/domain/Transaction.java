package com.example.pagarmepsp.domain;

import com.example.pagarmepsp.domain.enums.MetodoPagamento;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "valor")
    private BigDecimal valor;

    @Column(name = "metodo_pagamento")
    private MetodoPagamento metodoPagamento;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_cartao", nullable = false)
    private Cartao cartao;

    @Column(name = "criado_em")
    private LocalDateTime criadoEm;

    public Transaction() {
    }

    public Transaction(String descricao, BigDecimal valor, MetodoPagamento metodoPagamento, Cartao cartao, LocalDateTime criadoEm) {
        this.descricao = descricao;
        this.valor = valor;
        this.metodoPagamento = metodoPagamento;
        this.cartao = cartao;
        this.criadoEm = criadoEm;
    }

    public LocalDateTime getCriadoEm() {
        return criadoEm;
    }

    public String getDescricao() {
        return descricao;
    }

    public Cartao getCartao() {
        return cartao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public MetodoPagamento getMetodoPagamento() {
        return metodoPagamento;
    }
}
