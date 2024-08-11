package com.cbtc.cbtc.controllers;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.text.DecimalFormat;
import java.time.Duration;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.UrlResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cbtc.cbtc.repositories.HistoricoBTCBRLRepository;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class HistoricoBTCBRLController {

    @Autowired
    HistoricoBTCBRLRepository hBtcBrlRepository;

    public String HttpQuotationBTCBRL() throws IOException, InterruptedException{
        HttpRequest request = (HttpRequest) HttpRequest.newBuilder()
        .header("Accept", "application/json")
        .timeout(Duration.ofSeconds(5))
		.GET().uri(URI.create("https://api.coinbase.com/v2/prices/BTC-BRL/spot"))
		.build();

        HttpClient clientJava = HttpClient.newBuilder()
        .connectTimeout(Duration.ofSeconds(5))
        .build();
        HttpResponse<String> response  = clientJava.send(request, BodyHandlers.ofString());

        JSONObject jsonObj = new JSONObject(response.body());
        System.out.println("OBJ-JSON: "+ jsonObj.toString(5));

        double valor = jsonObj.getJSONObject("data").getDouble("amount");
        BigDecimal preco = new BigDecimal(valor).setScale(2, RoundingMode.HALF_UP);

        System.err.println(preco);

        DecimalFormat df = new DecimalFormat("###,###.##");
        String vf = df.format(preco);
        return vf;
    }

   @GetMapping("/buscar")
   public ResponseEntity<String> buscar() throws Exception{

        String resultado =  HttpQuotationBTCBRL();

        return ResponseEntity.ok().body("BTC-BRL - R$: "+resultado);
            
   }


}

