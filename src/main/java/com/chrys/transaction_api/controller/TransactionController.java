package com.chrys.transaction_api.controller;

import com.chrys.transaction_api.business.services.TransactionService;
import com.chrys.transaction_api.controller.dtos.RequestTransactionDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transaction")
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;

    @PostMapping
    public ResponseEntity<Void> addTransaction(@RequestBody RequestTransactionDTO dto) {
        transactionService.addTransaction(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteTransaction() {
        transactionService.deleteTransaction();
        return ResponseEntity.ok().build();
    }
}


