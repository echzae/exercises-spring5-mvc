/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.copyonwrite.sayinghello;

import org.springframework.stereotype.Service;

/**
 *
 * @author wolf
 */
@Service
class Greeter {
    public String greet(String name) {
        return String.format("Hello, %s, nice to meet you!", name == null ? "Nobody" : name);
    }
}
