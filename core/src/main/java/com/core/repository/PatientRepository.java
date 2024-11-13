package com.core.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.core.model.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
