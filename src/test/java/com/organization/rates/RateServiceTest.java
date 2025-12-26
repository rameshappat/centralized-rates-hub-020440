package com.organization.rates;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

/**
 * Test class for RateService.
 */
public class RateServiceTest {
    @InjectMocks
    private RateService rateService;

    @Mock
    private RateRepository rateRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindAllRates() {
        Rate rate = new Rate();
        rate.setId(1L);
        rate.setName("Test Rate");
        rate.setValue(BigDecimal.valueOf(1.5));
        rate.setEffectiveDate(LocalDate.now());
        when(rateRepository.findAll()).thenReturn(Collections.singletonList(rate));

        List<Rate> rates = rateService.findAllRates();

        assertEquals(1, rates.size());
        assertEquals("Test Rate", rates.get(0).getName());
    }

    @Test
    void testCreateRate() {
        Rate rate = new Rate();
        rate.setName("New Rate");
        rate.setValue(BigDecimal.valueOf(2.0));
        rate.setEffectiveDate(LocalDate.now());
        when(rateRepository.save(rate)).thenReturn(rate);

        Rate createdRate = rateService.createRate(rate);

        assertEquals("New Rate", createdRate.getName());
    }
}