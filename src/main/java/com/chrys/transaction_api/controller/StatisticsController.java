package com.chrys.transaction_api.controller;

import com.chrys.transaction_api.business.services.StatisticsService;
import com.chrys.transaction_api.controller.dtos.StatisticsResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/statistics")
@RequiredArgsConstructor
public class StatisticsController {

    private final StatisticsService statisticsService;

    @GetMapping
    @Operation(description = "Endpoint responsible for searching transactions statistics")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Statistics found successfully"),
            @ApiResponse(responseCode = "400", description = "Could not search for statistics"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<StatisticsResponseDTO> getStatistics(@RequestParam(value = "Search Range", required = false, defaultValue = "60") Integer Timestamp) {
        return ResponseEntity.ok(statisticsService.getStatistics(Timestamp));
    }
}
