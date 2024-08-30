package com.example.pagarmepsp.domain.enums;

public enum MetodoPagamento {

    DEBITO_CARD(0),
    CREDIT_CARD(1);

    private int metodoPagamento;

    MetodoPagamento(int metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }

    public static MetodoPagamento getMetodoPagamento(int status) {
        for (MetodoPagamento metodo : MetodoPagamento.values()) {
            if (metodo.metodoPagamento == status)
                return metodo;
        }

        return null;
    }
}
