package com.aukhatov.vaccinations.service;

import com.aukhatov.vaccinations.dao.Patient;

import java.util.List;

public interface PatientService {
    Patient addPatient(Patient patient);
    void deletePatient(String iian);
    Patient getPatient(String iian);
    Patient editPatient(Patient patient);
    List<Patient> getAllPatients();
}
