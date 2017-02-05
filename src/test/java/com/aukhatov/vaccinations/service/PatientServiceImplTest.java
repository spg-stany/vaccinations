package com.aukhatov.vaccinations.service;

import com.aukhatov.vaccinations.DataBaseConfig;
import com.aukhatov.vaccinations.dao.Gender;
import com.aukhatov.vaccinations.dao.Patient;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.sql.Date;
import java.time.LocalDate;

@DirtiesContext
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
    @Transactional
    public void testSavePatient() {
        Patient patient = new Patient();
        patient.setIian("32123456785");
        patient.setFirstName("Arthur");
        patient.setLastName("Aukhatov");
        patient.setBirthDate(Date.valueOf(LocalDate.of(1990, 8, 20)));
        patient.setGender(Gender.MALE);
        patientService.addPatient(patient);
    }

    @Test
    @Transactional
    public void testDeletePatient() {
        Patient patient = new Patient();
        patient.setIian("32123456785");
        patient.setFirstName("Arthur");
        patient.setLastName("Aukhatov");
        patient.setBirthDate(Date.valueOf(LocalDate.of(1990, 8, 20)));
        patient.setGender(Gender.MALE);
        patientService.addPatient(patient);
        patientService.deletePatient("32123456785");
    }

    @Test
    @Transactional
    public void testEditPatient() {
        Patient patient = new Patient();
        patient.setIian("32123456785");
        patient.setFirstName("Arthur");
        patient.setLastName("Aukhatov");
        patient.setBirthDate(Date.valueOf(LocalDate.of(1990, 8, 20)));
        patient.setGender(Gender.MALE);
        patientService.addPatient(patient);
        patient.setFirstName("Joshua");
        patient.setLastName("Bloch");
        patient.setBirthDate(Date.valueOf(LocalDate.of(1961, 8, 28)));
        patient.setGender(Gender.MALE);
        Patient editPatient = patientService.editPatient(patient);
        Assert.assertEquals(patient.getFirstName(), editPatient.getFirstName());
        Assert.assertEquals(patient.getLastName(), editPatient.getLastName());
        Assert.assertEquals(patient.getBirthDate(), editPatient.getBirthDate());
    }
}