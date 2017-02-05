package com.aukhatov.vaccinations.service.impl;

import com.aukhatov.vaccinations.dao.Vaccination;
import com.aukhatov.vaccinations.dao.repository.VaccinationRepository;
import com.aukhatov.vaccinations.service.VaccinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("vaccinationService")
@ComponentScan("com.aukhatov.vaccinations.dao")
public class VaccinationServiceImpl implements VaccinationService {

    @Autowired
    private VaccinationRepository vaccinationRepository;

    @Override
    public Vaccination addVaccination(Vaccination vaccination) {
        return vaccinationRepository.saveAndFlush(vaccination);
    }

    @Override
    public void deleteVaccination(long id) {
        vaccinationRepository.delete(id);
    }

    @Override
    public List<Vaccination> getAllVaccinationByPatient(String iian) {
        return vaccinationRepository.findByPatient(iian);
    }
}
