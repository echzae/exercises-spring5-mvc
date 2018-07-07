package com.copyonwrite.currencyconversion;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@Controller
public class CurrencyConversionController {
    @PostMapping("/exchange")
    String postExchange(@RequestParam Double euros, Model model) {
        RestTemplate restTemplate = new RestTemplate();
        OpenExchangeResponse response = restTemplate.getForObject(System.getenv(Constants.OPEN_EXCHANGE_APP_URL), OpenExchangeResponse.class);

        double rate = response.getRates().get("EUR");
        double dollars = euros / rate;

        model.addAttribute("exchange", String.format("%.2f€ at an exchange rate of %.2f is %.2f USD.", euros, rate, dollars));
        return "exchange";
    }
}
