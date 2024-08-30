package com.example.pagarmepsp.domain;

import com.example.pagarmepsp.Factory;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CartaoTest {

    @Nested
    class getUltimosTresDigitos {
        @Test
        void deveGuardarSomenteOsUltimosQuatroDigitos() {
            // arrange
            var numero = "12345678987654";

            // act
            Cartao cartao = Factory.criaCartao(numero);

            // assert
            assertEquals("7654", cartao.getNumero());
        }
    }

}