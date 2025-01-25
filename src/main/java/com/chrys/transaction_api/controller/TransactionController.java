package com.chrys.transaction_api.controller;

import com.chrys.transaction_api.business.services.TransactionService;
import com.chrys.transaction_api.controller.dtos.RequestTransactionDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    @Operation(description = "Endpoint responsible for adding transactions")
    @ApiResponses(value = {@ApiResponse(responseCode = "201", description = "Transaction added successfully"),
    @ApiResponse(responseCode = "422", description = "Fields not meeting application requirements"),
    @ApiResponse(responseCode = "400", description = "Could not process the request"),
    @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<Void> addTransaction(@RequestBody RequestTransactionDTO dto) {
        transactionService.addTransaction(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }



    @DeleteMapping
    @Operation(description = "Endpoint responsible for deleting transactions")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Transaction deleted successfully"),
            @ApiResponse(responseCode = "400", description = "Could not process the request"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<Void> deleteTransaction() {
        transactionService.deleteTransaction();
        return ResponseEntity.ok().build();
    }
}


