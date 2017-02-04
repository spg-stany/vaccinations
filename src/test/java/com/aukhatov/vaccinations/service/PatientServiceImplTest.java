package com.aukhatov.vaccinations.service;

import com.aukhatov.vaccinations.DataBaseConfig;
import com.aukhatov.vaccinations.dao.Patient;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import java.time.LocalDate;

import static org.junit.Assert.*;

//@DirtiesContext
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DataBaseConfig.class)
@WebAppConfiguration
public class PatientServiceImplTest {
    @Resource
    private EntityManagerFactory emf;
    protected EntityManager em;

    @Resource
    private PatientService patientService;

    @Before
    public void setUp() throws Exception {
        em = emf.createEntityManager();
    }

    @Test
    public void testSavePatient() {
        Patient patient = new Patient(1);
        patient.setFirstName("Arthur");
        patient.setLastName("Aukhatov");
        patient.setBirthDate(LocalDate.of(1990, 8, 20));
        patientService.addPatient(patient);
    }
}