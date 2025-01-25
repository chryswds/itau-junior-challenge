package com.chrys.transaction_api.controller;

import com.chrys.transaction_api.business.services.StatisticsService;
import com.chrys.transaction_api.controller.dtos.StatisticsResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/statistics")
@RequiredArgsConstructor
public class StatisticsController {

    private final StatisticsService statisticsService;

    public ResponseEntity<StatisticsResponseDTO> getStatistics(@RequestParam(value = "Search Range", required = false) Integer Timestamp) {
        return ResponseEntity.ok(statisticsService.getStatistics(searchTimestamp));
    }
}
