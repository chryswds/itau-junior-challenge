package com.chrys.transaction_api.business.services;

import com.chrys.transaction_api.controller.dtos.RequestTransactionDTO;
import com.chrys.transaction_api.infrastructure.exceptions.UnprocessableEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class TransactionService {

    private final List<RequestTransactionDTO> transactions = new ArrayList<>();

    public void addTransaction(RequestTransactionDTO dto) {

        log.info("Transaction process started");

        if(dto.timestamp().isAfter(OffsetDateTime.now())) {
            log.error("Date and time cannot be in the future");
            throw new UnprocessableEntity("cannot be in the future");
        }
        if(dto.value() < 0){
            log.error("value cannot be a negative value");
            throw new UnprocessableEntity("cannot be negative");
        }

        transactions.add(dto);
    }
}