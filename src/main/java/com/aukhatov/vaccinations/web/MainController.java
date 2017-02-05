package com.aukhatov.vaccinations.web;

import com.aukhatov.vaccinations.dao.Patient;
import com.aukhatov.vaccinations.dao.Vaccination;
import com.aukhatov.vaccinations.service.BaseService;
import com.aukhatov.vaccinations.service.PatientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/vaccinations")
public class MainController {
    private final Logger logger = LoggerFactory.getLogger(MainController.class);
    private final BaseService baseService;
    private static final String PATIENT_PATH = "/patient/";
    private static final String VACCINATION_PATH = "/patient/vaccination/";
    @Autowired
    private PatientService patientService;

    @Autowired
    public MainController(BaseService baseService) {
        this.baseService = baseService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        logger.debug("index() is executed!");
        return "This REST service!";
    }


    @RequestMapping(value = PATIENT_PATH + "{iian}", method = RequestMethod.GET)
    public Patient getPatient(@PathVariable("iian") String iian) {
        logger.info("Get Patient by IIAN: {}", iian);
        return patientService.getPatient(iian);
    }

    @RequestMapping(value = PATIENT_PATH, method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Patient addPatient(@RequestBody Patient patient) {
        logger.info("Add new Patient: {}", patient);
        return patientService.addPatient(patient);
    }

    @RequestMapping(value = PATIENT_PATH + "{iian}", method = RequestMethod.DELETE)
    public String deletePatient(@PathVariable("iian") String iian) {
        logger.info("Patient deleted by IIAN: {}", iian);
        patientService.deletePatient(iian);
        return "Deleted.";
    }

    @RequestMapping(value = PATIENT_PATH, method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Patient updatePatient(@RequestBody Patient patient) {
        logger.info("Update Patient: {}", patient);
        return patientService.editPatient(patient);
    }

    @RequestMapping(value = PATIENT_PATH, method = RequestMethod.GET)
    public List<Patient> getAllPatients() {
        logger.info("Get all Patients...");
        return patientService.getAllPatients();
    }

    @RequestMapping(value = VACCINATION_PATH + "{iian}", method = RequestMethod.GET)
    public List<Vaccination> getVaccinations(@PathVariable String iian) {
        logger.info("Get vaccinations by Patient: {}", iian);
        List<Vaccination> vaccinations = new ArrayList<>();
        return vaccinations;
    }

    @RequestMapping(value = VACCINATION_PATH, method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Vaccination addVaccination(@RequestBody Vaccination vaccination) {
        logger.debug("Add new vaccination id: {}", vaccination.getId());
        return vaccination;
    }

    @RequestMapping(value = VACCINATION_PATH + "{id}", method = RequestMethod.DELETE)
    public String deleteVaccination(@PathVariable String id) {
        logger.debug("Delete vaccination id: {}", id);
        return "Deleted.";
    }
}
