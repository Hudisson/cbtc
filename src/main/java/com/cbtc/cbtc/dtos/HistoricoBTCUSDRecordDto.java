package com.cbtc.cbtc.dtos;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record HistoricoBTCUSDRecordDto(@NotBlank String nameCoin, @NotNull BigDecimal currentPrice, @NotBlank String dateTime) {

    /**
     * String nameCoin;               // Nome da moeda
     * BigDecimal currentPrice;       // Preço ou cotação atual em USD
     * String dateTime;               // Data e hora 
     */

}
