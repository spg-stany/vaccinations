package com.aukhatov.vaccinations.util;

import com.aukhatov.vaccinations.dao.Patient;

/**
 * Created by aukhatov on 06.02.17.
 */
public class EntityUtils {
    public static boolean patientIsEmpty(Patient p) {
        return (p.getBirthDate() == null || p.getFirstName() == null || p.getGender() == null || p.getIian() == null
                || p.getLastName() == null);
    }
}
