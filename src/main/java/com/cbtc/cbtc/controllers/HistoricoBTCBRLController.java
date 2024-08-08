package com.cbtc.cbtc.controllers;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.text.DecimalFormat;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.cbtc.cbtc.repositories.HistoricoBTCBRLRepository;

@Controller
public class HistoricoBTCBRLController {

    @Autowired
    HistoricoBTCBRLRepository hBtcBrlRepository;

    public void HttpQuotationBTCBRL() throws IOException, InterruptedException{
        HttpRequest request = (HttpRequest) HttpRequest.newBuilder()
        .header("Accept", "application/json")
		.GET().uri(URI.create("https://api.coinbase.com/v2/prices/BTC-BRL/spot"))
		.build();

        HttpClient clientJava = HttpClient.newBuilder().build();
        HttpResponse<String> response  = clientJava.send(request, BodyHandlers.ofString());

        JSONObject jsonObj = new JSONObject(response.body());
        System.out.println("OBJ-JSON: "+ jsonObj.toString(5));

        double valor = jsonObj.getJSONObject("data").getDouble("amount");
        BigDecimal preco = new BigDecimal(valor).setScale(2, RoundingMode.HALF_UP);

        System.err.println(preco);

        DecimalFormat df = new DecimalFormat("###,###.##");
        String vf = df.format(preco);
        System.out.println("Preço R$:"+vf);
    }

    @GetMapping("/price")
    public void teste() throws IOException, InterruptedException{
        HttpQuotationBTCBRL();
    }
}

