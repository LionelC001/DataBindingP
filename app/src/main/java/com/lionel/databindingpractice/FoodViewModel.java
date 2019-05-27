package com.lionel.databindingpractice;

import android.app.Activity;
import android.databinding.Observable;
import android.databinding.ViewDataBinding;
import android.view.View;
import android.widget.Toast;

import com.lionel.databindingpractice.databinding.ActivityMainBinding;

public class FoodViewModel {

    private ViewDataBinding binding;
    private Activity activity;
    public Food food;
//    public FoodObservableField food;

    public FoodViewModel(Activity activity, ViewDataBinding binding) {
        this.activity = activity;
        this.binding = binding;
        this.binding.setVariable(BR.foodViewModel, this); //設定變數值, 種類在第一個參數宣告
    }

    public void bindValue(Food food) {
//        this.binding.setVariable(BR.food, food);   //設定變數值, 種類在第一個參數宣告
        this.food = food;
        food.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable sender, int propertyId) {
                String msg = "";
                switch (propertyId) {
                    case BR.brand:
                        msg = "brand";
                        break;
                    case BR.name:
                        msg = "name";
                        break;
                    case BR.calorie:
                        msg = "calorie";
                        break;
                }
                Toast.makeText(activity, msg + " is changed", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void bindValue(FoodObservableField food) {
//        this.food = food;
    }


    public void onChangeValue(View view) {
     /*   food.brand.set("BeeBeeBrand");
        food.calorie.set(999*0.5f);*/
        food.setBrand("OOXX BRAND");
        food.setCalorie(456789);
    }
}
