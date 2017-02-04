package com.aukhatov.vaccinations.dao.repository;

import com.aukhatov.vaccinations.dao.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
