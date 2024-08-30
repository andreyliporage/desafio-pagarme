package com.example.pagarmepsp.domain;

import com.example.pagarmepsp.Factory;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class PayableCreditoTest {

    @Nested
    class calculaSaldo {

        @Test
        void retornoCalculoDeveSer95() {
            // arrange
            var transaction = Factory.criaTransactionCredito();
            var payable = PayableFactory.criaPayable(transaction);

            //act
            var calculo = payable.calculaSaldo();

            // assert
            assertEquals(new BigDecimal("95.00"), calculo);
        }
    }

    @Nested
    class payableCredito {

        @Test
        void verificaDataDePagamentoD30() {
            // arrange
            var transaction = Factory.criaTransactionCredito();

            // act
            var payable = (PayableCredito) PayableFactory.criaPayable(transaction);
            var data = LocalDateTime.now().plusDays(30);

            // assert
            assertEquals(data.toLocalDate(), payable.getDataPagamento().toLocalDate());
        }
    }

}