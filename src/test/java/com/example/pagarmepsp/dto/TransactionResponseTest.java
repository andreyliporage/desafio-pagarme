package com.example.pagarmepsp.dto;

import com.example.pagarmepsp.Factory;
import com.example.pagarmepsp.domain.enums.MetodoPagamento;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TransactionResponseTest {

    @Nested
    class toTransaction {

        @Test
        void fromTransaction() {
            // arrange
            var transaction = Factory.criaTransactionDebito();

            // act
            var transactionResponse = TransactionResponse.fromTransaction(transaction);

            // assert
            assertEquals(transaction.getCriadoEm().toLocalDate(), transactionResponse.dataTransacao());
            assertEquals(transaction.getDescricao(), transactionResponse.descricao());
            assertEquals(transaction.getMetodoPagamento(), transactionResponse.metodoPagamento());
            assertEquals(transaction.getValor(), transactionResponse.valor());
        }
    }

}