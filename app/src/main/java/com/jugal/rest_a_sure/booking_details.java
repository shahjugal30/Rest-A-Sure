package com.jugal.rest_a_sure;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class booking_details extends AppCompatActivity implements DatePickerDialog.OnDateSetListener{

    private EditText editText;
    private EditText dateText;
    private EditText timeText;
    Context mContext = this;
    Spinner dropdownmenu;
    Button button;

    DatabaseReference databaseBooking;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_details);
        databaseBooking = FirebaseDatabase.getInstance().getReference("bookings");
        dateText = findViewById(R.id.date_book);
        dropdownmenu = (Spinner) findViewById(R.id.spinner);
        button = (Button) findViewById(R.id.confirmation);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addBooking();
            }
        });
         editText = (EditText) findViewById(R.id.book);
        List<String> list = new ArrayList<>();
        list.add("No. of Guests");
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");
        list.add("7");
        list.add("8");
        list.add("9");
        list.add("10");
        list.add("11");
        list.add("12");
        list.add("13");
        list.add("14");
        list.add("15");


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dropdownmenu.setAdapter(adapter);
        dropdownmenu.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String itemvalue = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



        timeText = findViewById(R.id.time_book);
        Calendar calendar = Calendar.getInstance();
        final int hour = calendar.get(Calendar.HOUR_OF_DAY);
        final int minute = calendar.get(Calendar.MINUTE);

        timeText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(mContext, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        timeText.setText(hourOfDay + ":" + minute);
                    }
                },hour,minute,android.text.format.DateFormat.is24HourFormat(mContext));
                timePickerDialog.show();
            }
        });
        dateText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog();

            }
        });
    }

    private void addBooking()
    {
        String name = editText.getText().toString().trim();
        String datee = dateText.getText().toString().trim();
        String timee = timeText.getText().toString().trim();
        String guests = dropdownmenu.getSelectedItem().toString();

        if (!TextUtils.isEmpty(name))
        {
            String id = databaseBooking.push().getKey();
            Booking booking = new Booking(id,name,datee,timee,guests);
            databaseBooking.child(id).setValue(booking);
            Toast.makeText(this,"Booking confirmed",Toast.LENGTH_LONG).show();

        }
        else
        {
            Toast.makeText(this,"You should enter the booking name",Toast.LENGTH_LONG).show();
        }

    }










    private void showDatePickerDialog()
    {
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, this,Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH),Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        String date =  + dayOfMonth +"/" + (month+1) + "/" + year;
        dateText.setText(date);

    }
}
