package com.aukhatov.vaccinations.dao;

import java.time.LocalDate;

public class Patient {
    private String firstName;
    private String lastName;
    private String patronymic;
    private LocalDate birthDate;
    private long iian;
    private enum gender {male, female}

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
