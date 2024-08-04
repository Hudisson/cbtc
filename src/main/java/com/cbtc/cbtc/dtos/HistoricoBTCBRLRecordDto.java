package com.cbtc.cbtc.dtos;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record HistoricoBTCBRLRecordDto(@NotBlank String nameCoin, @NotNull BigDecimal currentPrice, @NotBlank String dateTime) {
    

    /**
     * String nameCoin;               // Nome da moeda
     * BigDecimal currentPrice;       // Peço ou cotação atual em BRL
     * String dateTime;               // Data e hora 
     */

     
}
