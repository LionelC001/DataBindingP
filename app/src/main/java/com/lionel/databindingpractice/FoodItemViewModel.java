package com.lionel.databindingpractice;

import android.databinding.ViewDataBinding;
import android.view.View;

public class FoodItemViewModel {

    public Food food;

    public FoodItemViewModel(Food food) {
        this.food = food;
    }

    public void onFoodItemClick(View view) {
        food.setName("dont touch me");
    }
}
