package com.omer_h.repository;

import com.google.firebase.firestore.Query;

import com.omer_h.model.BASE.BaseEntity;
import com.omer_h.repository.BASE.BaseRepository;

public class Xrepository extends BaseRepository {
    @Override
    protected Query getQueryForExist(BaseEntity entity) {
        return null;
    }
}
