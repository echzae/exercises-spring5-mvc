/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.copyonwrite.taxcalculator;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author wolf
 */
@Controller
public class TaxCalculatorController {
    @PostMapping("/tax")
    String postTax(
            @RequestParam("amount") Double amount,
            @RequestParam("state") String state,
            Model model
    ) {
        model.addAttribute("answer", getAnswer(amount, state));
        
        return "tax";
    }

    private String getAnswer(Double amount, String state) {
        final double WISCONSIN_TAX = 5.5; // full percent
        final String WISCONSIN = "wi";
        
        if (state.toLowerCase().equals(WISCONSIN)) {
            double tax = Math.ceil(amount * WISCONSIN_TAX) / 100;
            return String.format("The subtotal is %.2f. The tax is %.2f. The total is %.2f.", amount, tax, amount + tax);
        }
        return String.format("The total is %.2f.", amount);
    }
}
