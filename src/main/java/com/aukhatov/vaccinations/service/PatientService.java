package com.aukhatov.vaccinations.service;

import com.aukhatov.vaccinations.dao.Patient;

import java.util.List;

public interface PatientService {
    Patient addPatient(Patient patient);
    void deletePatient(long iian);
    Patient getPatient(long iian);
    Patient editPatient(Patient patient);
    List<Patient> getAllPatients();
}
