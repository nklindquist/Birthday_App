package com.example.calendarapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.CalendarView;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Button;
import android.view.View;
import java.util.Scanner;
import android.text.InputType;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    CalendarView calendarView;
    TextView myDate;
    String name;

    EditText nameInput;
    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    public static final String EXTRA_MESSAGE = "com.example.android.calendarapp.extra.MESSAGE";
    private EditText mMessageEditText;


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

        final Button date = findViewById(R.id.saveBirthday);
        date.setOnClickListener(new View.OnClickListener() {
            String input = "Who's birthday is this day?: ";
            public void onClick(View v) {
                Scanner reader = new Scanner(System.in);
                myDate.setText(input);
                //personName = reader.next();
            }
        });

        final Button message = findViewById(R.id.sendMessage);
        message.setOnClickListener(new View.OnClickListener() {
            String mes = "Your happy birthday message has been sent :)";
            public void onClick(View v) {
                myDate.setText(mes);
            }
        });

        mMessageEditText = (EditText) findViewById(R.id.editText_main);
    }

    public void launchSecondActivity(View view) {
        Log.d(LOG_TAG, "Button clicked!");
        Intent intent = new Intent(this, SaveDate.class);
        String message = mMessageEditText.getText().toString();

        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
//    public void sendMessage(View view) {
//        System.out.println("Your happy birthday message has been sent :)");
//    }
//
//    String personName;
//    public void setDate(View view) {
//        Scanner reader = new Scanner(System.in);
//        System.out.println("Who's birthday is this day?: ");
//        personName = reader.next();
//    }
}
