package com.aukhatov.vaccinations.web;

import com.aukhatov.vaccinations.dao.Patient;
import com.aukhatov.vaccinations.service.BaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/vaccinations")
public class MainController {
    private final Logger logger = LoggerFactory.getLogger(MainController.class);
    private final BaseService baseService;
    private static final String PATIENT_PATH = "/patient/";

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
        logger.debug("Get Patient by IIAN: {}", iian);
        return new Patient(Long.valueOf(iian));
    }

    @RequestMapping(value = PATIENT_PATH, method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Patient addPatient(@RequestBody Patient patient) {
        logger.debug("Add new Patient: {}", patient.getIian());
        return patient;
    }

    @RequestMapping(value = PATIENT_PATH + "{iian}", method = RequestMethod.DELETE)
    public String deletePatient(@PathVariable("iian") String iian) {
        logger.debug("Patient deleted by IIAN: {}", iian);
        return "Deleted.";
    }

    @RequestMapping(value = PATIENT_PATH, method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Patient updatePatient(@RequestBody Patient patient) {
        logger.debug("Update Patient: {}", patient.getIian());
        return patient;
    }
}
