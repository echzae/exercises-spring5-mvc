package com.copyonwrite.selfcheckout;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SelfCheckoutController {
    @PostMapping("/self-checkout")
    String postSelfChecklout(
            @RequestParam("price1") Double price1,
            @RequestParam("quantity1") Integer quantity1,
            @RequestParam("price2") Double price2,
            @RequestParam("quantity2") Integer quantity2,
            @RequestParam("price3") Double price3,
            @RequestParam("quantity3") Integer quantity3,
            Model model
    ) {
        double subtotal = price1 * quantity1 + price2 * quantity2 + price3 * quantity3;
        double taxRate = 0.055;
        double tax = subtotal * taxRate;
        double total = subtotal + tax;

        model.addAttribute("subtotal", String.format("Subtotal: %.2f", subtotal));
        model.addAttribute("tax", String.format("Tax: %.2f", tax));
        model.addAttribute("total", String.format("Total: %.2f", total));

        return "self-checkout";
    }
}
