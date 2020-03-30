package com.jugal.rest_a_sure;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class BookingList extends ArrayAdapter<Booking> {

    private Activity context;
    private List<Booking> bookingList;

    public BookingList(Activity context, List<Booking> bookingList){
                super(context,R.layout.act_list,bookingList);
                this.context = context;
                this.bookingList=bookingList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.act_list,null,true);
        TextView bookname = (TextView) listViewItem.findViewById(R.id.bookingname);
        TextView datebook = (TextView) listViewItem.findViewById(R.id.bookingdate);
        TextView timebook = (TextView) listViewItem.findViewById(R.id.bookingtime);
        TextView guests = (TextView) listViewItem.findViewById(R.id.guests_no);

        Booking booking = bookingList.get(position);
        bookname.setText(booking.bookingname);
        datebook.setText(booking.bookingdate);
        timebook.setText(booking.bookingtime);
        guests.setText(booking.bookingguests);
        return listViewItem;


    }
}
