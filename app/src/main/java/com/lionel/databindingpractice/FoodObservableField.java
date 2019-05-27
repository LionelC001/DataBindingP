package com.lionel.databindingpractice;

import android.databinding.ObservableField;
import android.databinding.ObservableFloat;

/**
 * 此類別直接為雙向綁定, 不須寫notifyPropertyChange()
 */
public class FoodObservableField {
    public final ObservableField<String> brand = new ObservableField<>();
    public final ObservableField<String> name = new ObservableField<>();
    public final ObservableFloat calorie = new ObservableFloat();
}
