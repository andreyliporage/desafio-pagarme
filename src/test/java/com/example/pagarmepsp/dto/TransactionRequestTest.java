package com.example.pagarmepsp.dto;

import com.example.pagarmepsp.Factory;
import com.example.pagarmepsp.domain.enums.MetodoPagamento;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TransactionRequestTest {

    @Nested
    class toTransaction {

        @Test
        void deveMapearCorretamente() {
            // arrange
            var transactionRequest = Factory.criaTransactionRequest();
            var numeroCartaoLength = transactionRequest.numeroCartao().length();
            var numeroCartaoRequest = transactionRequest.numeroCartao().substring(numeroCartaoLength - 4, numeroCartaoLength);

            // act
            var transaction = transactionRequest.toTransaction();

            // assert
            assertEquals(numeroCartaoRequest, transaction.getCartao().getNumero());
            assertEquals(transactionRequest.descricao(), transaction.getDescricao());
            assertEquals(transactionRequest.valor(), transaction.getValor());
            assertEquals(MetodoPagamento.getMetodoPagamento(transactionRequest.metodoPagamento()), transaction.getMetodoPagamento());
        }
    }

}