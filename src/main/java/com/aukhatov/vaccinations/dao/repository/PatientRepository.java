package com.aukhatov.vaccinations.dao.repository;

import com.aukhatov.vaccinations.dao.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    @Query("select p from patient p where p.iian = :iian")
    Patient findByIian(@Param("iian") String iian);

    @Query("delete from patient p where p.iian = :iian")
    void deleteByIian(@Param("iian") String iian);
}
