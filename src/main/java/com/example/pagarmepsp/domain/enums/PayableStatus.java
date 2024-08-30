package com.example.pagarmepsp.domain.enums;

public enum PayableStatus {

    PAGO(0),
    AGUARDANDO_PAGAMENTO(1);

    private int status;

    PayableStatus(int status) {
        this.status = status;
    }
}
