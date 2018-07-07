package com.copyonwrite.paintcalculator;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ComputePaintController {
    @PostMapping("/compute-paint")
    String postComputePaint(@RequestParam("length") Integer length, @RequestParam("width") Integer width, Model model) {
        final int conversionGallonsPerSquareFeet = 350;
        final int gallons = (int) Math.ceil(((double)width * length)/conversionGallonsPerSquareFeet);

        model.addAttribute("answer",
                String.format(
                        "You will need to purchase %d gallons of paint to cover %d square feet.",
                gallons, width * length)
        );
        return "paint-information";
    }
}
