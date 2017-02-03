package com.aukhatov.vaccinations.web;

import com.aukhatov.vaccinations.dao.Patient;
import com.aukhatov.vaccinations.service.BaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/vaccinations")
public class MainController {
    private final Logger logger = LoggerFactory.getLogger(MainController.class);
    private final BaseService baseService;

    @Autowired
    public MainController(BaseService baseService) {
        this.baseService = baseService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        logger.debug("index() is executed!");
        return "This REST service!";
    }


    @RequestMapping(value = "/patient/{iian}", method = RequestMethod.GET)
    public Patient getPatient(@PathVariable("iian") String iian) {
        logger.debug("Get Patient by IIAN: {}", iian);
        return new Patient(Long.valueOf(iian));
    }
}
