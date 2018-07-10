package com.copyonwrite.determiningcompoundinterest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CompoundInterestRouter {
    @PostMapping("/compound-interest")
    CompoundInterest postCompoundInterest(@RequestBody CompoundInterestRequest request) {
        return CompoundInterest.from(request);
    }
}
