package com.omer_h.tashtit.ADPTERS;

import com.omer_h.model.Allergen;
import com.omer_h.tashtit.ADPTERS.BASE.GenericAdapter;

import java.util.List;

public class AllergenAdapter extends GenericAdapter<Allergen> {
    public AllergenAdapter(List<Allergen> items, int layoutId, InitializeViewHolder initializeViewHolder, BindViewHolder<Allergen> bindViewHolder) {
        super(items, layoutId, initializeViewHolder, bindViewHolder);
    }
}
