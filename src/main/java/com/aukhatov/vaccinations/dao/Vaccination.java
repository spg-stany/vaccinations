package com.aukhatov.vaccinations.dao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Vaccination {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long iian;
    private String medicineName;
    private LocalDate dateExecute;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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
