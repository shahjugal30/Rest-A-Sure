package com.jugal.rest_a_sure;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CuisineFragment extends Fragment {
    @Nullable
    String[] dishes_name = {"Arabian","Bakery","Barbeque","Biryani","Burgers","Cafe","Chaat","Chinese","Dessert","Indian","Italian","Lebanese","Maharashtrain","Mexican","Mughlai","Multicuisine","North Indian","Rajasthani","Sandwich","Seafood","South Indian","Street Food","Thai"};
    int[] dishes_img = {R.drawable.arabian,R.drawable.bakery,R.drawable.bbq,R.drawable.biryani,R.drawable.burgers,R.drawable.cafe,R.drawable.chaat,R.drawable.chinese,R.drawable.desserts,R.drawable.indian,R.drawable.italian,R.drawable.lebanese,R.drawable.maharashtrain,R.drawable.mexican,R.drawable.mughlai,R.drawable.multicuisine,R.drawable.north_indian,R.drawable.rajasthani,R.drawable.sandwich,R.drawable.seafood,R.drawable.south_indian,R.drawable.street_food,R.drawable.thai};


    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_cuisine,container,false);

        GridView gridView = (GridView) view.findViewById(R.id.grid_view);
        MainAdapter adapter = new MainAdapter(CuisineFragment.this,dishes_name,dishes_img);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {




            }
        });





        return view;


    }
}
