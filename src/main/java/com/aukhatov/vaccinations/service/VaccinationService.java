package com.aukhatov.vaccinations.service;

import com.aukhatov.vaccinations.dao.Vaccination;

import java.util.List;

public interface VaccinationService {
    Vaccination addVaccination(Vaccination vaccination);
    void deleteVaccination(long id);
    List<Vaccination> getAllVaccinationByPatient(long iian);
}
