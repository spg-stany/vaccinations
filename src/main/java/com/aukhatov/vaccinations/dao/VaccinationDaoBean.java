package com.aukhatov.vaccinations.dao;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class VaccinationDaoBean implements VaccinationDao {
    @Override
    public List<Vaccination> getAllVaccinationByPatient(long iian) {
        return null;
    }

    @Override
    public long addVaccination(Vaccination v) {
        return 0;
    }

    @Override
    public void deleteVaccination(long iian) {

    }
}
