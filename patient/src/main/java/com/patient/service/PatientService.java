package com.patient.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.core.model.Patient;
import com.core.repository.PatientRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    // Get all patients
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    
    public Optional<Patient> getPatientById(Long id) {
        return patientRepository.findById(id);
    }

    public Patient createPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    // Update an existing patient
    public Patient updatePatient(Long id, Patient patientDetails) {
        Optional<Patient> existingPatient = patientRepository.findById(id);
        if (existingPatient.isPresent()) {
            Patient patient = existingPatient.get();
            patient.setName(patientDetails.getName());
            patient.setAge(patientDetails.getAge());
            return patientRepository.save(patient);
        }
        return null; // Or throw a custom exception for not found
    }

    // Delete a patient by ID
    public boolean deletePatient(Long id) {
        if (patientRepository.existsById(id)) {
            patientRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
