package com.aukhatov.vaccinations.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Patient {
    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Column(name = "last_name", nullable = false)
    private String lastName;
    @Column(name = "patronymic")
    private String patronymic;
    @Column(name = "birth_date", nullable = false)
    private LocalDate birthDate;
    @Id
    private long iian;
//    @Column(name = "gender", nullable = false)
//    private enum gender {male, female}

    public Patient() {
    }

    public Patient(long iian) {
        this.iian = iian;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public long getIian() {
        return iian;
    }

    public void setIian(long iian) {
        this.iian = iian;
    }
}
