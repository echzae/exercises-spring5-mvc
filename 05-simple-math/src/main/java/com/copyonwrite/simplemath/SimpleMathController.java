/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.copyonwrite.simplemath;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author wolf
 */
@Controller
public class SimpleMathController {
    @PostMapping("/post-numbers")
    public String postNumbers(
            @RequestParam("firstNumber") Integer first, 
            @RequestParam("secondNumber") Integer second,
            Model model
    ) {
        int fst = first;
        int snd = second;
        model.addAttribute("resultAddition", String.format("%d + %d = %d", fst, snd, fst + snd));
        model.addAttribute("resultSubtraction", String.format("%d - %d = %d", fst, snd, fst - snd));
        model.addAttribute("resultMultiplication", String.format("%d * %d = %d", fst, snd, fst * snd));
        model.addAttribute("resultDivision", String.format("%d / %d = %.2f", fst, snd, 
                    snd == 0 ? 0 : (double) fst / snd));
        return "show-result";
    }
}
