package com.chrys.transaction_api.controller.dtos;

import java.time.OffsetDateTime;

public record RequestTransactionDTO(Double value, OffsetDateTime timestamp) {
}