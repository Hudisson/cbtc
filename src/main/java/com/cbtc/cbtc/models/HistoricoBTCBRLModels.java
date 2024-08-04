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
@Table(name = "tbl_historico_btc_brl")
public class HistoricoBTCBRLModels extends RepresentationModel<HistoricoBTCBRLModels> implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID hBtcBrlId;                 // Identificador único

    private String nameCoin;                // Nome da moeda
    private BigDecimal currentPrice;        // Peço ou cotação atual em BRL
    private String dateTime;                // Data e hora ()

    public static long getSerialversionuid() {
        return serialVersionUID;
    }
    public UUID gethBtcBrlId() {
        return hBtcBrlId;
    }
    public void sethBtcBrlId(UUID hBtcBrlId) {
        this.hBtcBrlId = hBtcBrlId;
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
