package com.omer_h.viewmodel;

import android.app.Application;

import com.omer_h.model.Medicine;
import com.omer_h.model.Medicines;
import com.omer_h.model.PersonalInfo;
import com.omer_h.model.PersonalInfos;
import com.omer_h.repository.BASE.BaseRepository;
import com.omer_h.repository.MedicineRepository;
import com.omer_h.repository.PersonalInfoRepository;
import com.omer_h.viewmodel.BASE.BaseViewModel;

public class MedicineViewModel extends BaseViewModel<Medicine, Medicines> {
    private MedicineRepository repository;

    public MedicineViewModel(Class<Medicine> tEntity, Class<Medicines> tCollection, Application application) {
        super(Medicine.class, Medicines.class, application);
    }

    @Override
    protected BaseRepository<Medicine, Medicines> createRepository(Application application) {
        repository=new MedicineRepository(application);
        return repository;
    }
}
