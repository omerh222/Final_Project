package com.omer_h.repository;

import android.app.Application;
import android.service.autofill.Presentations;

import com.google.firebase.firestore.Query;
import com.omer_h.model.PersonalInfo;
import com.omer_h.model.PersonalInfos;
import com.omer_h.model.Prescription;
import com.omer_h.model.Prescriptions;
import com.omer_h.repository.BASE.BaseRepository;

public class PrescriptionRepository extends BaseRepository<Prescription, Prescriptions> {
    public PrescriptionRepository(Application application) {
        super(Prescription.class, Prescriptions.class, application);
    }

    @Override
    protected Query getQueryForExist(Prescription entity) {
        return null;
    }
}
