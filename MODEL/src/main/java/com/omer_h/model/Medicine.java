package com.omer_h.model;

import com.omer_h.model.BASE.BaseEntity;

import java.io.Serializable;
import java.util.Objects;

public class Medicine extends BaseEntity implements Serializable {
    private String  name;
    private String  manufacturer;
    private String  howToTake;
    private String  activeSub;
    private boolean isPrescriptionDrug;

    public Medicine(){
    }

    public Medicine(String name, String manufacturer, String howToTake, String activeSub, boolean isPrescriptionDrug) {
        this.name = name;
        this.manufacturer = manufacturer;
        this.howToTake = howToTake;
        this.activeSub = activeSub;
        this.isPrescriptionDrug = isPrescriptionDrug;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getHowToTake() {
        return howToTake;
    }

    public void setHowToTake(String howToTake) {
        this.howToTake = howToTake;
    }

    public String getActiveSub() {
        return activeSub;
    }

    public void setActiveSub(String activeSub) {
        this.activeSub = activeSub;
    }

    public boolean isPrescriptionDrug() {
        return isPrescriptionDrug;
    }

    public void setPrescriptionDrug(boolean prescriptionDrug) {
        isPrescriptionDrug = prescriptionDrug;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Medicine)) return false;
        if (!super.equals(o)) return false;
        Medicine medicine = (Medicine) o;
        return isPrescriptionDrug == medicine.isPrescriptionDrug && Objects.equals(name, medicine.name) && Objects.equals(manufacturer, medicine.manufacturer) && Objects.equals(howToTake, medicine.howToTake) && Objects.equals(activeSub, medicine.activeSub);
    }
}
