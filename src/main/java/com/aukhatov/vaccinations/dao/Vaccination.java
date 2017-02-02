package com.aukhatov.vaccinations.dao;

import java.time.LocalDate;

public class Vaccination {
    private long iian;
    private String medicineName;
    private LocalDate dateExecute;

    public long getIian() {
        return iian;
    }

    public void setIian(long iian) {
        this.iian = iian;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public LocalDate getDateExecute() {
        return dateExecute;
    }

    public void setDateExecute(LocalDate dateExecute) {
        this.dateExecute = dateExecute;
    }
}
