package com.aukhatov.vaccinations.web;

import com.aukhatov.vaccinations.dao.Patient;
import com.aukhatov.vaccinations.dao.Vaccination;
import com.aukhatov.vaccinations.exception.InvalidDataException;
import com.aukhatov.vaccinations.service.BaseService;
import com.aukhatov.vaccinations.service.PatientService;
import com.aukhatov.vaccinations.service.VaccinationService;
import com.aukhatov.vaccinations.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/vaccinations")
public class MainController {
    private final Logger logger = LoggerFactory.getLogger(MainController.class);
    private final BaseService baseService;
    private static final String PATIENT_PATH = "/patient/";
    @Autowired
    private PatientService patientService;
    @Autowired
    private VaccinationService vaccinationService;
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
    public Patient getPatient(@PathVariable("iian") String iian) throws InvalidDataException {
        if (iian.length() != 11) {
            logger.error("Patient iian length [{}] invalid.", iian);
            throw new InvalidDataException("InvalidDataException: IIAN length must be 11.");
        }
        logger.info("Get Patient by IIAN: {}", iian);
        return patientService.getPatient(iian);
    }

    @RequestMapping(value = PATIENT_PATH, method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Patient addPatient(@RequestBody Patient patient) throws InvalidDataException {
        if (EntityUtils.patientIsEmpty(patient)) {
            logger.error("Try to put null object.");
            throw new InvalidDataException("Input data is empty!");
        }
        logger.info("Add new Patient: {}", patient);
        return patientService.addPatient(patient);
    }

    @RequestMapping(value = PATIENT_PATH + "{iian}", method = RequestMethod.DELETE)
    public String deletePatient(@PathVariable("iian") String iian) {
        logger.info("Patient deleted by IIAN: {}", iian);
        patientService.deletePatient(iian);
        return "Deleted.";
    }

    @RequestMapping(value = PATIENT_PATH + "{iian:[\\d]+}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Patient updatePatient(@PathVariable String iian, @RequestBody Patient patient) throws InvalidDataException {
        if (iian.length() != 11) {
            logger.error("Patient iian length [{}] invalid.", iian);
            throw new InvalidDataException("InvalidDataException: IIAN length must be 11.");
        }

        logger.info("Update Patient: {}", patient);
        return patientService.editPatient(patient);
    }

    @RequestMapping(value = PATIENT_PATH, method = RequestMethod.GET)
    public List<Patient> getAllPatients() {
        logger.info("Get all Patients...");
        return patientService.getAllPatients();
    }

    @RequestMapping(value = "/patient/{iian:[\\d]+}/vaccination/", method = RequestMethod.GET)
    public List<Vaccination> getVaccinations(@PathVariable String iian) {
        logger.info("Get vaccinations by Patient: {}", iian);
        return vaccinationService.getAllVaccinationByPatient(iian);
    }

    @RequestMapping(value = "/patient/{iian:[\\d]+}/vaccination/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Vaccination addVaccination(@RequestBody Vaccination vaccination) throws InvalidDataException {
        if (EntityUtils.vaccinationIsEmpty(vaccination)) {
            logger.error("Try to put null object.");
            throw new InvalidDataException("Input data is empty!");
        }
        logger.info("Add new vaccination id: {}", vaccination.getId());
        return vaccinationService.addVaccination(vaccination);
    }

    @RequestMapping(value = "/patient/{iian:[\\d]+}/vaccination/{id}", method = RequestMethod.DELETE)
    public String deleteVaccination(@PathVariable String id) {
        logger.info("Delete vaccination id: {}", id);
        vaccinationService.deleteVaccination(Long.valueOf(id));
        return "Deleted.";
    }

    @ExceptionHandler(InvalidDataException.class)
    public ResponseEntity<String> invalidDataExceptionHandler(Exception e) {
        logger.info("Exception handled...");
        return new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
    }
}
