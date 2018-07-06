package com.copyonwrite.pizzaparty;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PizzaPartyController {
    @PostMapping("/compute-slices")
    public String postComputeSlices(
            @RequestParam("people") Integer people,
            @RequestParam("pizzas") Integer pizzas,
            @RequestParam("slices") Integer slices,
            Model model
    ) {
        int totalslices = pizzas * slices;
        int personslices = totalslices / people;
        int restSlices = totalslices % people;

        model.addAttribute("situation", String.format("%d people with %d pizzas.", people, pizzas));
        model.addAttribute("slices", String.format("Each person gets %d pieces of pizza.", personslices));
        model.addAttribute("leftover", String.format("There are %d leftover pieces.", restSlices));

        return "distribution";
    }
}
