package com.aukhatov.vaccinations.service;

import com.aukhatov.vaccinations.DataBaseConfig;
import com.aukhatov.vaccinations.dao.Vaccination;
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
@Transactional
public class VaccinationServiceImplTest {

    @Resource
    private EntityManagerFactory emf;
    protected EntityManager em;

    @Resource
    private VaccinationService vaccinationService;

    @Before
    public void setUp() throws Exception {
        em = emf.createEntityManager();
    }

    @Test
    public void testAdd() {
        Vaccination vaccination = new Vaccination();
        vaccination.setIian("32456781999");
        vaccination.setDateExecute(Date.valueOf(LocalDate.of(2017, 2, 4)));
        vaccination.setMedicineName("BCJ");
        Assert.assertNotNull(vaccinationService.addVaccination(vaccination));
    }

    @Test
    public void testDelete() {
        Vaccination vaccination = new Vaccination();
        vaccination.setIian("54356781999");
        vaccination.setDateExecute(Date.valueOf(LocalDate.of(2017, 2, 4)));
        vaccination.setMedicineName("Super medicine");
        Vaccination otherVaccination = vaccinationService.addVaccination(vaccination);
        Assert.assertNotNull(otherVaccination);
        vaccinationService.deleteVaccination(otherVaccination.getId());
    }
}