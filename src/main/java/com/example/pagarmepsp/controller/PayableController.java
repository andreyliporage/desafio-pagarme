package com.example.pagarmepsp.controller;

import com.example.pagarmepsp.dto.PayableResponse;
import com.example.pagarmepsp.service.PayableService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payables")
public class PayableController {

    private final PayableService service;

    public PayableController(PayableService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<PayableResponse> get() {
        return ResponseEntity.ok(service.get());
    }
}
