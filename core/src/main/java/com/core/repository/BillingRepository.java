package com.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.core.model.Billing;

public interface BillingRepository extends JpaRepository<Billing, Long> {
}

