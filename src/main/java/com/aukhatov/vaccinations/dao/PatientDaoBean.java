package com.aukhatov.vaccinations.dao;

import org.springframework.stereotype.Component;

import java.util.List;

@Component("patientDao")
public class PatientDaoBean implements PatientDao {
    @Override
    public List<Patient> getAllPatients() {
        return null;
    }

    @Override
    public Patient getPatient(long iian) {
        return null;
    }

    @Override
    public long addPatient(Patient p) {
        return 0;
    }

    @Override
    public void editPatient(Patient p) {

    }

    @Override
    public void deletePatient(long iian) {

    }
}
