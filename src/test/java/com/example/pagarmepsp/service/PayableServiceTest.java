package com.example.pagarmepsp.service;

import com.example.pagarmepsp.Factory;
import com.example.pagarmepsp.domain.Payable;
import com.example.pagarmepsp.domain.PayableCredito;
import com.example.pagarmepsp.domain.PayableDebito;
import com.example.pagarmepsp.domain.PayableFactory;
import com.example.pagarmepsp.dto.PayableResponse;
import com.example.pagarmepsp.repository.PayableRepository;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PayableServiceTest {

    @Mock
    PayableRepository payableRepository;

    @InjectMocks
    PayableService payableService;

    @Nested
    class get {

        @Test
        void deveChamarRepositoryFindAll() {
            // arrange
            doReturn(Factory.retornaListaDePayable()).when(payableRepository).findAll();

            // act
            var response = payableService.get();

            // verify
            verify(payableRepository, times(1)).findAll();
        }

        @Test
        void deveRetornarPayableResponseComCalculo() {
            // arrange
            var payableCredito = mock(PayableCredito.class);
            var payableDebito = mock(PayableDebito.class);

            when(payableCredito.calculaSaldo()).thenReturn(new BigDecimal("95.00"));
            when(payableDebito.calculaSaldo()).thenReturn(new BigDecimal("97.00"));

            List<Payable> payables = new ArrayList<>(List.of(payableDebito, payableCredito));

            when(payableRepository.findAll()).thenReturn(payables);

            // act
            PayableResponse response = payableService.get();

            // assert/verify
            assertEquals(new BigDecimal("95.00"), response.waiting_funds());
            assertEquals(new BigDecimal("97.00"), response.available());
        }
    }

}