package com.copyonwrite.legaldrivingage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author wolf
 */
@Controller
public class LegalDrivingAgeController {
    private final CheckAgeService checkAgeService;

    @Autowired
    public LegalDrivingAgeController(CheckAgeService checkAgeService) {
        this.checkAgeService = checkAgeService;
    }
    
    @GetMapping("/")
    String getIndex() { return "index"; }
    
    @PostMapping("/is-legal")
    String postIsLegal(
            @RequestParam("age") Integer age,
            Model model
    ) {
        model.addAttribute("legal", this.checkAgeService.isLegal(age));
        return "islegal";
    }
}
