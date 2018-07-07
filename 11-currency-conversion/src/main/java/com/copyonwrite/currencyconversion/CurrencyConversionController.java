package com.copyonwrite.currencyconversion;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CurrencyConversionController {
    @PostMapping("/exchange")
    String postExchange(@RequestParam Double euros, Model model) {
        double rate = 137.51;
        double dollars = euros * rate / 100;
        model.addAttribute("exchange", String.format("%.2f€ at an exchange rate of %.2f is %.2f USD.", euros, rate, dollars));
        return "exchange";
    }
}
