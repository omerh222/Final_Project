package com.omer_h.model;

import com.omer_h.model.BASE.BaseEntity;

import java.io.Serializable;
import java.util.Objects;

public class PersonalInfo extends BaseEntity implements Serializable {
    private String firstName;
    private String lastName;
    private long   birthDate;
    private Allergens allergens;
    private String emergencyNum;
    private String email;
    private String password;


    public PersonalInfo() {
    }

    public PersonalInfo(String firstName, String lastName, Long birthDate, Allergens allergens, String emergencyNum, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.allergens = allergens;
        this.emergencyNum = emergencyNum;
        this.email = email;
        this.password = password;
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

    public Long getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Long birthDate) {
        this.birthDate = birthDate;
    }

    public Allergens getAllergens() {
        return allergens;
    }

    public void setAllergens(Allergens allergens) {
        this.allergens = allergens;
    }

    public String getEmergencyNum() {
        return emergencyNum;
    }

    public void setEmergencyNum(String emergencyNum) {
        this.emergencyNum = emergencyNum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PersonalInfo)) return false;
        if (!super.equals(o)) return false;
        PersonalInfo that = (PersonalInfo) o;
        return birthDate == that.birthDate && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && Objects.equals(allergens, that.allergens) && Objects.equals(emergencyNum, that.emergencyNum) && Objects.equals(email, that.email) && Objects.equals(password, that.password);
    }
}
