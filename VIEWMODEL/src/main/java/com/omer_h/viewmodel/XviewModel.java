package com.omer_h.viewmodel;

import android.app.Application;

import com.omer_h.repository.BASE.BaseRepository;
import com.omer_h.viewmodel.BASE.BaseViewModel;

public class XviewModel extends BaseViewModel {
    @Override
    protected BaseRepository createRepository(Application application) {
        return null;
    }

    public XviewModel(Class tEntity, Class tCollection, Application application) {
        super(tEntity, tCollection, application);
    }
}
