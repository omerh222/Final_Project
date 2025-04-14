package com.omer_h.model;

import com.omer_h.model.BASE.BaseEntity;

import java.io.Serializable;
import java.util.Objects;

public class Allergen extends BaseEntity implements Serializable {
    private String name;
    private String userIdFs;

    public Allergen(){
    }

    public Allergen(String name, String userIdFs) {
        this.name = name;
        this.userIdFs = userIdFs;

    }

    public void setName(String name)
    {
        this.name=name;
    }

    public String getName()
    {
        return this.name;
    }

    public String getUserIdFs() {
        return userIdFs;
    }

    public void setUserIdFs(String userIdFs) {
        this.userIdFs = userIdFs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Allergen)) return false;
        if (!super.equals(o)) return false;
        Allergen allergen = (Allergen) o;
        return Objects.equals(name, allergen.name) && Objects.equals(userIdFs, allergen.userIdFs);
    }
}
