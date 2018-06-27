/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.copyonwrite.sayinghello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author wolf
 */
@Controller
public class HelloController {
    @Autowired
    private Greeter greeter;
    @GetMapping
    public String index() {
        return "index";
    }
    
    @PostMapping("/sayhello")
    public String sayhello(@RequestParam("name") String name, Model model) {
        model.addAttribute("greeting", greeter.greet(name));
        return "sayhello";
    }
}
