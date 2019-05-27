package com.lionel.databindingpractice;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lionel.databindingpractice.databinding.ItemRecyclerviewFoodBinding;

import java.util.List;

public class FoodRecyclerViewAdapter extends RecyclerView.Adapter<FoodRecyclerViewAdapter.FoodViewHolder> {

    private final List<Food> dataSource;

    public FoodRecyclerViewAdapter(List<Food> list) {
        this.dataSource = list;
    }

    public class FoodViewHolder<T extends ViewDataBinding> extends RecyclerView.ViewHolder {

        private T binding;

        public FoodViewHolder(T binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public T getBinding() {
            return binding;
        }
    }

    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewDataBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_recyclerview_food, parent, false);
//        ViewDataBinding binding1 = ItemRecyclerviewFoodBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new FoodViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder holder, int position) {
        holder.getBinding().setVariable(BR.foodItemViewModel, new FoodItemViewModel(dataSource.get(position)));
//        holder.getBinding().getRoot().setOnClickListener(new onClickListener(position));
    }

    @Override
    public int getItemCount() {
        return dataSource == null ? 0 : dataSource.size();
    }


    private class onClickListener implements View.OnClickListener {
        private final int position;

        private onClickListener(int position) {
            this.position = position;
        }

        @Override
        public void onClick(View v) {
            dataSource.get(position).setName("Have u pressed just?");
        }
    }
}
