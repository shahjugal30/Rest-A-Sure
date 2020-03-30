package com.jugal.rest_a_sure;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PreviewBookingFragment extends Fragment {

    ListView myListView;
    List<Booking>bookingList;
    private DatabaseReference databaseBooking;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_preview_booking,container,false);
        myListView = (ListView)view.findViewById(R.id.listViewbooking);
        bookingList = new ArrayList<>();
        databaseBooking = FirebaseDatabase.getInstance().getReference("bookings");
        databaseBooking.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                bookingList.clear();
                for (DataSnapshot bookingSnapshot: dataSnapshot.getChildren() )
                {
                    Booking booking = bookingSnapshot.getValue(Booking.class);
                    bookingList.add(booking);
                }
                BookingList adapter = new BookingList((Activity) getContext(),bookingList);
                myListView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });



        return view;
    }
}
