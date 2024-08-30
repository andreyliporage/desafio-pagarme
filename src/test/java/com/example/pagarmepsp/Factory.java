package com.example.pagarmepsp;

import com.example.pagarmepsp.domain.*;
import com.example.pagarmepsp.domain.enums.MetodoPagamento;
import com.example.pagarmepsp.dto.PayableResponse;
import com.example.pagarmepsp.dto.TransactionRequest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Factory {

    public static Cartao criaCartao() {
        String numero = "12345678987654";
        String nomePortador = "Lima";
        LocalDate data = LocalDate.now();
        String cvv = "123";

        return new Cartao(numero, nomePortador, data, cvv);
    }

    public static Cartao criaCartao(String numeroCartao) {
        String numero = numeroCartao;
        String nomePortador = "Lima";
        LocalDate data = LocalDate.now();
        String cvv = "123";

        return new Cartao(numero, nomePortador, data, cvv);
    }

    public static Transaction criaTransactionCredito() {
        String descricao = "Rolex";
        BigDecimal valor = new BigDecimal(100);
        MetodoPagamento metodoPagamento = MetodoPagamento.CREDIT_CARD;
        Cartao cartao = Factory.criaCartao();
        LocalDateTime criadoEm = LocalDateTime.now();

        return new Transaction(descricao, valor, metodoPagamento, cartao, criadoEm);
    }

    public static Transaction criaTransactionDebito() {
        String descricao = "Rolex";
        BigDecimal valor = new BigDecimal(100);
        MetodoPagamento metodoPagamento = MetodoPagamento.DEBITO_CARD;
        Cartao cartao = Factory.criaCartao();
        LocalDateTime criadoEm = LocalDateTime.now();

        return new Transaction(descricao, valor, metodoPagamento, cartao, criadoEm);
    }

    public static TransactionRequest criaTransactionRequest() {
        String descricao = "Rolex";
        String numero = "12345678987654";
        int metodoPagamento = 0;
        BigDecimal valor = new BigDecimal(100);
        String nomePortador = "Lima";
        LocalDate data = LocalDate.now();
        String cvv = "123";

        return new TransactionRequest(valor, descricao, numero, metodoPagamento, nomePortador, data, cvv);
    }

    public static List<Payable> retornaListaDePayable() {
        return new ArrayList<>(List.of(PayableFactory.criaPayable(criaTransactionDebito())));
    }

    public static PayableResponse retornaPayableResponse() {
        return new PayableResponse(new BigDecimal("100.00"), new BigDecimal("100.00"));
    }
}
