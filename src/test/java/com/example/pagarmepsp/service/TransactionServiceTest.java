package com.example.pagarmepsp.service;

import com.example.pagarmepsp.Factory;
import com.example.pagarmepsp.domain.Transaction;
import com.example.pagarmepsp.repository.TransactionRepository;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TransactionServiceTest {

    @Mock
    TransactionRepository repository;

    @InjectMocks
    TransactionService service;

    @Nested
    class get {

        @Test
        void deveChamarRepositoryFindAll() {
            // arrange
            List<Transaction> transactions = new ArrayList<>(List.of(Factory.criaTransactionDebito(), Factory.criaTransactionCredito()));

            doReturn(transactions).when(repository).findAll();

            // act
            var response = service.get();

            // assert
            verify(repository, times(1)).findAll();
        }

    }

}