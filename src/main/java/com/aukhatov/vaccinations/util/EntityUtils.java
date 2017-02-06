package com.aukhatov.vaccinations.util;

import com.aukhatov.vaccinations.dao.Patient;
import com.aukhatov.vaccinations.dao.Vaccination;

/**
 * Created by aukhatov on 06.02.17.
 */
public class EntityUtils {
    public static boolean patientIsEmpty(Patient p) {
        return (p.getBirthDate() == null || p.getFirstName() == null || p.getGender() == null || p.getIian() == null
                || p.getLastName() == null || p.getFirstName().equals("") || p.getIian().equals(""));
    }

    public static boolean vaccinationIsEmpty(Vaccination v) {
        return (v.getDateExecute() == null || v.getIian() == null || v.getMedicineName() == null
                || v.getMedicineName().equals("") || v.getIian().equals(""));
    }
}
