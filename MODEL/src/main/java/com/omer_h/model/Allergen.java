package com.omer_h.model;

import com.omer_h.model.BASE.BaseEntity;

import java.io.Serializable;
import java.util.Objects;

public class Allergen extends BaseEntity implements Serializable {
    private String name;

    public Allergen(){
    }

    public Allergen(String name) {
        this.name = name;
    }

    public void setName(String name)
    {
        this.name=name;
    }

    public String getName()
    {
        return this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Allergen)) return false;
        if (!super.equals(o)) return false;
        Allergen allergen = (Allergen) o;
        return Objects.equals(name, allergen.name);
    }
}
