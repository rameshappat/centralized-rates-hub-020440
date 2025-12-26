package com.organization.rates;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for Rate entity.
 */
@Repository
public interface RateRepository extends JpaRepository<Rate, Long> {
}