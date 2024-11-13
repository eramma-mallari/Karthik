package com.billing.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.core.model.Billing;
import com.core.repository.BillingRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BillingService {

    @Autowired
    private BillingRepository billingRepository;

    public List<Billing> getAllBillings() {
        return billingRepository.findAll();
    }

    public Billing getBillingById(Long id) {
        return billingRepository.findById(id).orElse(null);
    }

    public Billing createBilling(Billing billing) {
        return billingRepository.save(billing);
    }

    public Billing updateBilling(Long id, Billing billing) {
        Optional<Billing> existingBilling = billingRepository.findById(id);
        if (existingBilling.isPresent()) {
            billing.setId(id); // Ensure the ID remains the same
            return billingRepository.save(billing);
        }
        return null;
    }

    public boolean deleteBilling(Long id) {
        if (billingRepository.existsById(id)) {
            billingRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
