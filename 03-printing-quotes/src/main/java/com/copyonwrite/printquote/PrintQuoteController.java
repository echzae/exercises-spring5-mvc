/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.copyonwrite.printquote;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author wolf
 */
@Controller
public class PrintQuoteController {
    @PostMapping("/post-quote")
    String postQuote(@RequestParam("quote") String quote, @RequestParam("author") String author, Model model) {
        model.addAttribute("displayQuote", author + " says, \"" + quote + "\"");
        return "show-quote";
    }
}
