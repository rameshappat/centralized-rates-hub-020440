package com.organization.rates;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * REST controller for handling Rate requests.
 */
@RestController
@RequestMapping("/api/rates")
public class RateController {
    private final RateService rateService;

    @Autowired
    public RateController(RateService rateService) {
        this.rateService = rateService;
    }

    @GetMapping
    public ResponseEntity<List<Rate>> getAllRates() {
        List<Rate> rates = rateService.findAllRates();
        return new ResponseEntity<>(rates, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Rate> createRate(@RequestBody Rate rate) {
        Rate createdRate = rateService.createRate(rate);
        return new ResponseEntity<>(createdRate, HttpStatus.CREATED);
    }
}