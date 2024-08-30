package com.example.pagarmepsp.service;

import com.example.pagarmepsp.domain.Payable;
import com.example.pagarmepsp.domain.PayableDebito;
import com.example.pagarmepsp.dto.PayableResponse;
import com.example.pagarmepsp.repository.PayableRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class PayableService {

    private final PayableRepository repository;

    public PayableService(PayableRepository repository) {
        this.repository = repository;
    }

    public PayableResponse get() {
        var payables = repository.findAll();

        return montaRetorno(payables);
    }

    private PayableResponse montaRetorno(List<Payable> payables) {
        var saldoDisponivel = BigDecimal.ZERO;
        var saldoWaitingFunds = BigDecimal.ZERO;

        for (Payable payable : payables) {
            if (payable instanceof PayableDebito)
                saldoDisponivel = saldoDisponivel.add(payable.calculaSaldo());
            else
                saldoWaitingFunds = saldoWaitingFunds.add(payable.calculaSaldo());
        }

        return new PayableResponse(saldoDisponivel, saldoWaitingFunds);
    }
}
