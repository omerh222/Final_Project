package com.omer_h.repository;

import android.app.Application;

import com.google.firebase.firestore.Query;
import com.omer_h.model.PersonalInfo;
import com.omer_h.model.PersonalInfos;
import com.omer_h.repository.BASE.BaseRepository;

public class PersonalInfoRepository extends BaseRepository<PersonalInfo, PersonalInfos> {
    public PersonalInfoRepository(Application application) {
        super(PersonalInfo.class, PersonalInfos.class, application);
    }

    @Override
    protected Query getQueryForExist(PersonalInfo entity) {
        return getCollection().whereEqualTo("email", entity.getEmail());
    }
}
