package com.lionel.databindingpractice;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private Food food;
//    private FoodObservableField food;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewDataBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        food = new Food("樂事", "韓式泡菜鍋", 140 * 2.5f);

//        food = new FoodObservableField();
//        food.name.set("韓式泡菜鍋");
//        food.brand.set("樂事");
//        food.calorie.set(140*2.5f);

        FoodViewModel foodViewModel = new FoodViewModel(this, binding);
        foodViewModel.bindValue(food);


        initRecyclerView();
    }

    private void initRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        FoodRecyclerViewAdapter adapter = new FoodRecyclerViewAdapter(genFoods());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
    }

    private List<Food> genFoods() {
        List<Food> foods = new ArrayList<>();

        for (int i = 1; i <= 100; i++) {
            String brand = "b" + i;
            String name = "n" + i;
            float calorie = (float) Math.random() * 9999;
            foods.add(new Food(brand, name, calorie));
        }

        return foods;
    }
}
