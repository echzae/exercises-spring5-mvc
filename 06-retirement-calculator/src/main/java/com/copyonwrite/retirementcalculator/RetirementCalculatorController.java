/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.copyonwrite.retirementcalculator;

import java.time.LocalDateTime;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author wolf
 */
@Controller
public class RetirementCalculatorController {
    @PostMapping("compute-retirement")
    String computeRetirement(
            @RequestParam("currentAge") Integer currentAge, 
            @RequestParam("retirementAge") Integer retirementAge,
            Model model
    ) {
        LocalDateTime now = LocalDateTime.now();
        int yearsLeft = retirementAge - currentAge;
        LocalDateTime retirementYear = now.plusYears(yearsLeft);
        model.addAttribute("yearsLeft", String.format("You have %d years left until you can retire.", yearsLeft));
        model.addAttribute("retirementYear", String.format("It's %s, so you can retire in %s.", now.getYear(), retirementYear.getYear()));
        
        return "retirement-plan";
    }
}
