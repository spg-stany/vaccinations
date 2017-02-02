package com.aukhatov.vaccinations.dao;

import java.util.List;

public interface VaccinationDao {
    List<Vaccination> getAllVaccinationByPatient(long iian);
    long addVaccination(Vaccination v);
    void deleteVaccination(long iian);
}
