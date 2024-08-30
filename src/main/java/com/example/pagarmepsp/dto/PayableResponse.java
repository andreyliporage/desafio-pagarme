package com.example.pagarmepsp.dto;

import java.math.BigDecimal;

public record PayableResponse(
        BigDecimal available,
        BigDecimal waiting_funds
) {
}
