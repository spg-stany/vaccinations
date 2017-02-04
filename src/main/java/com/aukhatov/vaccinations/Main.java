package com.aukhatov.vaccinations;

import com.aukhatov.vaccinations.config.SpringRootConfig;
import com.aukhatov.vaccinations.dao.Patient;
import com.aukhatov.vaccinations.service.PatientService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by aukhatov on 04.02.17.
 */
public class Main {
    public static void main(String[] args) {
        try(AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(SpringRootConfig.class)){
            PatientService patientService = context.getBean(PatientService.class);
            patientService.addPatient(new Patient(222));
        }
    }
}
