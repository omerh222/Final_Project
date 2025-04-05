package com.omer_h.viewmodel;

import android.app.Application;

import com.omer_h.model.PersonalInfo;
import com.omer_h.model.PersonalInfos;
import com.omer_h.repository.BASE.BaseRepository;
import com.omer_h.repository.PersonalInfoRepository;
import com.omer_h.viewmodel.BASE.BaseViewModel;

public class PersonalInfoViewModel extends BaseViewModel<PersonalInfo, PersonalInfos> {
    private PersonalInfoRepository repository;

    public PersonalInfoViewModel(Class<PersonalInfo> tEntity, Class<PersonalInfos> tCollection, Application application) {
        super(PersonalInfo.class, PersonalInfos.class, application);
    }

    @Override
    protected BaseRepository<PersonalInfo, PersonalInfos> createRepository(Application application) {
        repository=new PersonalInfoRepository(application);
        return repository;
    }
}
