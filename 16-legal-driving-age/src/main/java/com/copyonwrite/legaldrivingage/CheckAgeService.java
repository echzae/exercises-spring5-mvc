package com.copyonwrite.legaldrivingage;

import org.springframework.stereotype.Service;

/**
 *
 * @author wolf
 */
@Service
public class CheckAgeService {
    private final int LEGAL_AGE = 16;
    
    String isLegal(int age) {
        return age >= LEGAL_AGE ? "You are old enough to legally drive." : "You are not old enough to legally drive.";
    }
}
