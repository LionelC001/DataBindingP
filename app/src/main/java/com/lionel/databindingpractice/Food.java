package com.lionel.databindingpractice;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.view.View;
import android.widget.Toast;

/**
 * Model Class
 */
public class Food extends BaseObservable {
    private String brand;
    private String name;
    private float calorie;

    public Food(String brand, String name, float calorie) {
        this.brand = brand;
        this.name = name;
        this.calorie = calorie;
    }

    @Bindable
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
        notifyPropertyChanged(BR.brand);
    }

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    @Bindable
    public float getCalorie() {
        return calorie;
    }

    public void setCalorie(float calorie) {
        this.calorie = calorie;
        notifyPropertyChanged(BR.calorie);
    }
}
