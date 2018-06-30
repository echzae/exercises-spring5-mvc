/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.copyonwrite.madlib;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author wolf
 */
@Controller
public class MadLibController {

    @PostMapping("/post-words")
    public String postWords(
            @RequestParam("noun") String noun,
            @RequestParam("verb") String verb,
            @RequestParam("adjective") String adjective,
            @RequestParam("adverb") String adverb,
            Model model
    ) {
        String story = String.format(
                "Do you %s your %s %s %s? That's hilarious!",
                verb,
                adjective,
                noun,
                adverb
        );
        model.addAttribute("story", story);
        return "post-words";
    }
}
