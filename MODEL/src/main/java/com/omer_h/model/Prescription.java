package com.omer_h.model;

import com.omer_h.model.BASE.BaseEntity;

import java.io.Serializable;
import java.util.Objects;

public class Prescription extends BaseEntity implements Serializable {
    private String  patient;
    private String  prescribingDoctor;
    private String  MedicineID;
    private int     medFrequency;
    private boolean isLifeSaving;
    private enum    medTakingTime {Before, During, After, Irrelevant;}
    private String  dosage;
    private long    datePrescribed;

    public Prescription(){
    }

    public Prescription(String prescribingDoctor, String medicineID, int medFrequency, boolean isLifeSaving, String dosage, String patient, long datePrescribed) {
        this.prescribingDoctor = prescribingDoctor;
        this.MedicineID = medicineID;
        this.medFrequency = medFrequency;
        this.isLifeSaving = isLifeSaving;
        this.dosage = dosage;
        this.patient = patient;
        this.datePrescribed = datePrescribed;
    }

    public String getPrescribingDoctor() {
        return prescribingDoctor;
    }

    public void setPrescribingDoctor(String prescribingDoctor) {
        this.prescribingDoctor = prescribingDoctor;
    }

    public String getMedicineID() {
        return MedicineID;
    }

    public void setMedicineID(String medicineID) {
        MedicineID = medicineID;
    }

    public String getPatient() {
        return patient;
    }

    public void setPatient(String patient) {
        this.patient = patient;
    }

    public int getMedFrequency() {
        return medFrequency;
    }

    public void setMedFrequency(int medFrequency) {
        this.medFrequency = medFrequency;
    }

    public boolean isLifeSaving() {
        return isLifeSaving;
    }

    public void setLifeSaving(boolean lifeSaving) {
        isLifeSaving = lifeSaving;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public long getDatePrescribed() {
        return datePrescribed;
    }

    public void setDatePrescribed(long datePrescribed) {
        this.datePrescribed = datePrescribed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Prescription)) return false;
        if (!super.equals(o)) return false;
        Prescription that = (Prescription) o;
        return medFrequency == that.medFrequency && isLifeSaving == that.isLifeSaving && datePrescribed == that.datePrescribed && Objects.equals(patient, that.patient) && Objects.equals(prescribingDoctor, that.prescribingDoctor) && Objects.equals(MedicineID, that.MedicineID) && Objects.equals(dosage, that.dosage);
    }
}
