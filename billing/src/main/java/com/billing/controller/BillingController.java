package com.billing.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.billing.service.BillingService;
import com.core.model.Billing;

import java.util.List;

@RestController
@RequestMapping("/billings")
public class BillingController {

    @Autowired
    private BillingService billingService;

    // Get all billings
    @GetMapping
    public ResponseEntity<List<Billing>> getAllBillings() {
        List<Billing> billings = billingService.getAllBillings();
        return new ResponseEntity<>(billings, HttpStatus.OK);
    }

    // Get a billing by ID
    @GetMapping("/{id}")
    public ResponseEntity<Billing> getBillingById(@PathVariable Long id) {
        Billing billing = billingService.getBillingById(id);
        if (billing != null) {
            return new ResponseEntity<>(billing, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Create a new billing
    @PostMapping
    public ResponseEntity<Billing> createBilling(@RequestBody Billing billing) {
        Billing createdBilling = billingService.createBilling(billing);
        return new ResponseEntity<>(createdBilling, HttpStatus.CREATED);
    }

    // Update an existing billing
    @PutMapping("/{id}")
    public ResponseEntity<Billing> updateBilling(@PathVariable Long id, @RequestBody Billing billing) {
        Billing updatedBilling = billingService.updateBilling(id, billing);
        if (updatedBilling != null) {
            return new ResponseEntity<>(updatedBilling, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete a billing by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBilling(@PathVariable Long id) {
        boolean isDeleted = billingService.deleteBilling(id);
        if (isDeleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
