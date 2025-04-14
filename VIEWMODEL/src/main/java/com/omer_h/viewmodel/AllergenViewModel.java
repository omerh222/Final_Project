package com.omer_h.viewmodel;

import android.app.Application;

import com.omer_h.model.Allergen;
import com.omer_h.model.Allergens;
import com.omer_h.model.PersonalInfo;
import com.omer_h.model.PersonalInfos;
import com.omer_h.repository.AllergenRepository;
import com.omer_h.repository.BASE.BaseRepository;
import com.omer_h.repository.PersonalInfoRepository;
import com.omer_h.viewmodel.BASE.BaseViewModel;

import java.util.ArrayList;

public class AllergenViewModel extends BaseViewModel<Allergen, Allergens> {
    private AllergenRepository repository;

    public AllergenViewModel(Application application) {
        super(Allergen.class, Allergens.class, application);
    }

    @Override
    protected BaseRepository<Allergen, Allergens> createRepository(Application application) {
        repository = new AllergenRepository(application);
        return repository;
    }
}
