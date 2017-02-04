package com.aukhatov.vaccinations.service.impl;

import com.aukhatov.vaccinations.dao.Patient;
import com.aukhatov.vaccinations.dao.repository.PatientRepository;
import com.aukhatov.vaccinations.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@ComponentScan("com.aukhatov.vaccinations.dao")
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public Patient addPatient(Patient patient) {
        return patientRepository.saveAndFlush(patient);
    }

    @Override
    public void deletePatient(long iian) {
        patientRepository.delete(iian);
    }

    @Override
    public Patient getPatient(long iian) {
        return patientRepository.findOne(iian);
    }

    @Override
    public Patient editPatient(Patient patient) {
        return patientRepository.saveAndFlush(patient);
    }

    @Override
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }
}
