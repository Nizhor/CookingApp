package com.example.cookingapp;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.widget.TextView;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.List;

public class RecyclerViewConfig {
    private Context mContext;
    private MealsAdapter mealsAdapter;

    public void setConfig(RecyclerView recyclerView, Context context, List<Meal> meals, List<String> keys) {
        mContext = context;
        mealsAdapter = new MealsAdapter(meals, keys);
        recyclerView.setAdapter(mealsAdapter);
    }

    class MenuItemView extends RecyclerView.ViewHolder {
        private TextView txtMealName;
        private TextView txtDescription;

        private String key;

        public MenuItemView(ViewGroup parent) {
            super(LayoutInflater.from(mContext)
                    .inflate(R.layout.menu_list_item, parent, false));

            txtMealName = (TextView) itemView.findViewById(R.id.txtMealNameMenu);
            txtDescription = (TextView) itemView.findViewById(R.id.txtDescription);
        }

        public void bind(Meal meal, String key) {
            txtMealName.setText(meal.getMealName());
            txtDescription.setText(meal.getMealDescription());
            this.key = key;
        }

    }

    class MealsAdapter extends RecyclerView.Adapter<MenuItemView>{
        private List<Meal> mealList;
        private List<String> keys;

        public MealsAdapter(List<Meal> mealList, List<String> keys) {
            this.mealList = mealList;
            this.keys = keys;
        }

        @NonNull
        @Override
        public MenuItemView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new MenuItemView(parent);
        }

        @Override
        public void onBindViewHolder(@NonNull MenuItemView holder, int position) {
            holder.bind(mealList.get(position), keys.get(position));
        }

        @Override
        public int getItemCount() {
            return mealList.size();
        }
    }
}

