package com.chrys.transaction_api.business.services;

import com.chrys.transaction_api.controller.dtos.RequestTransactionDTO;
import com.chrys.transaction_api.controller.dtos.StatisticsResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.DoubleSummaryStatistics;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StatisticsService {

    public final TransactionService transactionService;

    public StatisticsResponseDTO getStatistics(Integer searchTimestamp) {
        List<RequestTransactionDTO> transactions = transactionService.searchTransaction(searchTimestamp);

        DoubleSummaryStatistics statistics = transactions.stream()
                .mapToDouble(RequestTransactionDTO::value)
                .summaryStatistics();

        return new StatisticsResponseDTO(statistics.getCount(),
                statistics.getSum(),
                statistics.getAverage(),
                statistics.getMax(),
                statistics.getMin());
    }
}
