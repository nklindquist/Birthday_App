package com.example.calendarapp;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Button;
import android.view.View;

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
                String date = ((1 + month) + "/" + dayOfMonth + "/" + year + " is a birthday, don't forget to send your wishes!");
                myDate.setText(date);
            }
        });

        Button setDate = findViewById(R.id.myDate);
        setDate.setOnClickListener(v -> {

        });

        Button message = findViewById(R.id.sendMessage);
        message.setOnClickListener(v -> {

        });
    }
    public void sendMessage(View view) {
        System.out.println("Your happy birthday message has been sent :)");
    }

    String personName;
    public void setDate(View view) {
        System.out.println("Who's birthday is this day?: ");
        personName = 
    }
}
