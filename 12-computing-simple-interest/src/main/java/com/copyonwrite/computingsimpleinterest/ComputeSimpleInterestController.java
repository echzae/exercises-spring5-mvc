package com.copyonwrite.computingsimpleinterest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ComputeSimpleInterestController {
    @PostMapping("/simple-interest")
    String postSimpleInterest(
            @RequestParam("principal") Integer principal,
            @RequestParam("interest") Double interest,
            @RequestParam("years") Integer years,
            Model model
    ) {
        double result = principal * (1 + (interest/100) * years);

        String answer = String.format("After %d years at %.1f interest, the investment will be worth %.2f.",
                years,
                interest,
                result
        );
        model.addAttribute("answer", answer);


        return "simple-interest";
    }
}
