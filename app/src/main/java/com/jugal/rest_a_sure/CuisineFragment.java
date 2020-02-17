package com.jugal.rest_a_sure;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CuisineFragment extends Fragment {
    @Nullable

    List<Dishes> lstDish;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_cuisine,container,false);
        lstDish = new ArrayList<>();
        lstDish.add(new Dishes("Arabian",R.drawable.arabian));
        lstDish.add(new Dishes("Bakery",R.drawable.bakery));
        lstDish.add(new Dishes("Barbeque",R.drawable.bbq));
        lstDish.add(new Dishes("Biryani",R.drawable.biryani));
        lstDish.add(new Dishes("Burger",R.drawable.burgers));
        lstDish.add(new Dishes("Cafe",R.drawable.cafe));
        lstDish.add(new Dishes("Chaat",R.drawable.chaat));
        lstDish.add(new Dishes("Chinese",R.drawable.chinese));
        lstDish.add(new Dishes("Dessert",R.drawable.desserts));
        lstDish.add(new Dishes("Indian",R.drawable.indian));
        lstDish.add(new Dishes("Italian",R.drawable.italian));
        lstDish.add(new Dishes("Lebanese",R.drawable.lebanese));
        lstDish.add(new Dishes("Maharastrain",R.drawable.maharashtrain));
        lstDish.add(new Dishes("Mexican",R.drawable.mexican));
        lstDish.add(new Dishes("Mughlai",R.drawable.mughlai));
        lstDish.add(new Dishes("Multicuisine",R.drawable.multicuisine));
        lstDish.add(new Dishes("North Indian",R.drawable.north_indian));
        lstDish.add(new Dishes("Rajasthani",R.drawable.rajasthani));
        lstDish.add(new Dishes("Sandwich",R.drawable.sandwich));
        lstDish.add(new Dishes("Seafood",R.drawable.seafood));
        lstDish.add(new Dishes("South Indian",R.drawable.south_indian));
        lstDish.add(new Dishes("Street Food",R.drawable.street_food));
        lstDish.add(new Dishes("Thai",R.drawable.thai));

        RecyclerView myrv = (RecyclerView) view.findViewById(R.id.recycler);
        RecyclerViewAdapter myAdapter = new RecyclerViewAdapter(getActivity(),lstDish);
        myrv.setLayoutManager (new GridLayoutManager(getActivity() ,2));
        myrv.setAdapter(myAdapter);


        return view;
    }
}
