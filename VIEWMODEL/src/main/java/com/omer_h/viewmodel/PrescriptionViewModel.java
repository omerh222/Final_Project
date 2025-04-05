package com.omer_h.viewmodel;

import android.app.Application;

import com.omer_h.model.PersonalInfo;
import com.omer_h.model.PersonalInfos;
import com.omer_h.model.Prescription;
import com.omer_h.model.Prescriptions;
import com.omer_h.repository.BASE.BaseRepository;
import com.omer_h.repository.PersonalInfoRepository;
import com.omer_h.repository.PrescriptionRepository;
import com.omer_h.viewmodel.BASE.BaseViewModel;

public class PrescriptionViewModel extends BaseViewModel<Prescription, Prescriptions> {
    private PrescriptionRepository repository;

    public PrescriptionViewModel(Class<Prescription> tEntity, Class<Prescriptions> tCollection, Application application) {
        super(Prescription.class, Prescriptions.class, application);
    }

    @Override
    protected BaseRepository<Prescription, Prescriptions> createRepository(Application application) {
        repository=new PrescriptionRepository(application);
        return repository;
    }
}
