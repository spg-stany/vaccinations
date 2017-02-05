package com.aukhatov.vaccinations.dao.repository;

import com.aukhatov.vaccinations.dao.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    @Query("select p from Patient p where p.iian = :iian")
    Patient findByIian(@Param("iian") String iian);

    @Modifying
    @Transactional
    @Query("delete from Patient p where p.iian = ?1")
    void deleteByIian(String iian);
}
