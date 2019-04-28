package com.example.calendarapp;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    CalendarView calendarView;
    TextView myDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calendarView = (CalendarView) findViewById(R.id.calendarView);
        myDate = (TextView) findViewById(R.id.myDate);

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                String date = ((1 + month) + "/" + dayOfMonth + "/" + year + " is a birthday! Don't forget to send your wishes.");
                myDate.setText(date);
            }
        });

        final Imagebutton setDate = findViewById(R.id.myDate);
        setDate.setOnClickListener(v -> {
            Log.d(TAG, "Who's birthday is this day?: ");
            startSetDate();
        });

        final Imagebutton message = findViewById(R.id.sendMessage);
        message.setOnClickListener(v -> {
            Log.d(TAG, "Happy Birthday message sent :) ");
            startmessage();
        });
    }
}
