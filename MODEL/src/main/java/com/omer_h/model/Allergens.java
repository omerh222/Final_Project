package com.omer_h.model;

import com.omer_h.model.BASE.BaseList;

public class Allergens extends BaseList<Allergen, Allergens> {
    public Allergens allergensByUserIdFs(String userIdFs) {
        Allergens finalList = new Allergens();
        for(Allergen allergen:this)
        {
            if(allergen.getUserIdFs().equals(userIdFs))
                finalList.add(allergen);
        }
        return finalList;
    }
}
