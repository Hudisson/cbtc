package com.cbtc.cbtc.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

import org.springframework.hateoas.RepresentationModel;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_historico_btc_usd")
public class HistoricoBTCUSDModels extends  RepresentationModel<HistoricoBTCUSDModels> implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID hBtcUsdId;                 // Identificador único

    private String nameCoin;                // Nome da moeda
    private BigDecimal currentPrice;        // Peço atual
    private String dateTime;                // Data e hora ()
    
    public static long getSerialversionuid() {
        return serialVersionUID;
    }
    public UUID gethBtcUsdId() {
        return hBtcUsdId;
    }
    public void sethBtcUsdId(UUID hBtcUsdId) {
        this.hBtcUsdId = hBtcUsdId;
    }
    public String getNameCoin() {
        return nameCoin;
    }
    public void setNameCoin(String nameCoin) {
        this.nameCoin = nameCoin;
    }
    public BigDecimal getCurrentPrice() {
        return currentPrice;
    }
    public void setCurrentPrice(BigDecimal currentPrice) {
        this.currentPrice = currentPrice;
    }
    public String getDateTime() {
        return dateTime;
    }
    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    
}
