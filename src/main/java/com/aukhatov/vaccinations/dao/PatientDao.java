package com.aukhatov.vaccinations.dao;

import java.util.List;

public interface PatientDao {
    List<Patient> getAllPatients();
    Patient getPatient(long iian);
    long addPatient(Patient p);
    void editPatient(Patient p);
    void deletePatient(long iian);
}
