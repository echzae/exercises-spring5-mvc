/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.copyonwrite.passwordvalidation;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author wolf
 */
@Controller
public class PasswordValidationController {
    @PostMapping("/login")
    String postLogin(
      @RequestParam("name") String name,
      @RequestParam("password") String password,
      Model model
    ) {
      if (name.equals("wolf") && password.equals("abc")) {
          model.addAttribute("result", "Hello, Wolf!");
      } else {
          model.addAttribute("result", "Go away!");
      }
        
      return "result";
    }
}
