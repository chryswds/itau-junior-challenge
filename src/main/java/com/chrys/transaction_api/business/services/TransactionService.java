package com.chrys.transaction_api.business.services;

import com.chrys.transaction_api.controller.dtos.RequestTransactionDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionService {

    private final List<RequestTransactionDTO> transactions = new ArrayList<>();


}