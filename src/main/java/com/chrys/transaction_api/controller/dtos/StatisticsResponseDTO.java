package com.chrys.transaction_api.controller.dtos;

public record StatisticsResponseDTO(Long count, double sum, double avg, double max, double min) {
}
