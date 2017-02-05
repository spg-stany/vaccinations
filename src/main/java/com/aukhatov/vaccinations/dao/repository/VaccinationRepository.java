package com.aukhatov.vaccinations.dao.repository;

import com.aukhatov.vaccinations.dao.Vaccination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VaccinationRepository extends JpaRepository<Vaccination, Long> {

    @Query("select v from Vaccination v where v.iian = :iian")
    List<Vaccination> findByPatient(@Param("iian") String iian);
}
