package com.omer_h.repository;

import android.app.Application;

import com.google.firebase.firestore.Query;
import com.omer_h.model.Allergen;
import com.omer_h.model.Allergens;
import com.omer_h.repository.BASE.BaseRepository;

public class AllergenRepository extends BaseRepository<Allergen, Allergens> {
    public AllergenRepository(Application application) {
        super(Allergen.class, Allergens.class, application);
    }
    @Override
    protected Query getQueryForExist(Allergen entity) {
        return getCollection().whereEqualTo("name", entity.getName());
    }
}
