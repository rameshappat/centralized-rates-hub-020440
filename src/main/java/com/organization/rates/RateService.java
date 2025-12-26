package com.organization.rates;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Service class for managing Rates.
 */
@Service
public class RateService {
    private final RateRepository rateRepository;

    @Autowired
    public RateService(RateRepository rateRepository) {
        this.rateRepository = rateRepository;
    }

    public List<Rate> findAllRates() {
        return rateRepository.findAll();
    }

    public Rate createRate(Rate rate) {
        return rateRepository.save(rate);
    }

    // Additional methods for update, delete, etc.
}