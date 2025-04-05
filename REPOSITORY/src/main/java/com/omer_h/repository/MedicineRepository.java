package com.omer_h.repository;

import android.app.Application;

import com.google.firebase.firestore.Query;
import com.omer_h.model.Medicines;
import com.omer_h.model.Medicine;
import com.omer_h.repository.BASE.BaseRepository;

public class MedicineRepository extends BaseRepository<Medicine, Medicines> {
    public MedicineRepository(Application application) {
        super(Medicine.class, Medicines.class, application);
    }
    @Override
    protected Query getQueryForExist(Medicine entity) {
        return getCollection().whereEqualTo("name", entity.getName());
    }
}
