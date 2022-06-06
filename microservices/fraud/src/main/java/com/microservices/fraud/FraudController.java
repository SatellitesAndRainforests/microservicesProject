package com.microservices.fraud;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/fraud-check")
@AllArgsConstructor
@Slf4j
public class FraudController {

    private final FraudCheckService fraudCheckService;

    @GetMapping(path = "{customerId}")
    public FraudCheckResponse isFraudster( @PathVariable("customerId") Integer customerId ){
        // the log addition will mena we don't have to check the database as often.
        log.info("fraud check request for customer {}", customerId);
        return new FraudCheckResponse( fraudCheckService.isFraudulentCustomer(customerId) );
    }

}
