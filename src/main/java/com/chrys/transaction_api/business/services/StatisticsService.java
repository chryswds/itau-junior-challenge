package com.chrys.transaction_api.business.services;

import com.chrys.transaction_api.controller.dtos.RequestTransactionDTO;
import com.chrys.transaction_api.controller.dtos.StatisticsResponseDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.DoubleSummaryStatistics;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class StatisticsService {

    public final TransactionService transactionService;

    public StatisticsResponseDTO getStatistics(Integer searchTimestamp) {

        log.info("Transaction statistics process started - " + searchTimestamp);
        List<RequestTransactionDTO> transactions = transactionService.searchTransaction(searchTimestamp);

        if(transactions.isEmpty()) {
            log.info("No transactions found");
            return new StatisticsResponseDTO(0L, 0.0, 0.0, 0.0, 0.0);
        }
        DoubleSummaryStatistics statistics = transactions.stream()
                .mapToDouble(RequestTransactionDTO::value)
                .summaryStatistics();

        log.info("Transaction statistics process completed");

        return new StatisticsResponseDTO(statistics.getCount(),
                statistics.getSum(),
                statistics.getAverage(),
                statistics.getMax(),
                statistics.getMin());
    }
}
