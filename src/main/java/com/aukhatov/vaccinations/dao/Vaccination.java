package com.aukhatov.vaccinations.dao;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "vaccination")
public class Vaccination {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "iian", nullable = false, length = 11)
    private String iian;

    @Column(name = "medicine_name", nullable = false)
    private String medicineName;

    @Column(name = "date_execute", nullable = false)
    private Date dateExecute;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getIian() {
        return iian;
    }

    public void setIian(String iian) {
        this.iian = iian;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public Date getDateExecute() {
        return dateExecute;
    }

    public void setDateExecute(Date dateExecute) {
        this.dateExecute = dateExecute;
    }
}
