package com.example.blooddonor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.android.twoactivities.extra.MESSAGE";

    LinearLayout request;
    LinearLayout donate;
    LinearLayout appointment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//Date/Time
        request = findViewById(R.id.request_textView);
        request.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DateTimeActivity.class);
                startActivity(intent);

                Toast.makeText(MainActivity.this, "You clicked on request blood", Toast.LENGTH_SHORT).show();
            }
        });

//Donate
        donate = findViewById(R.id.donate_textView);
        donate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DonateActivity.class);
                startActivity(intent);

                Toast.makeText(MainActivity.this, "You clicked on donate blood", Toast.LENGTH_SHORT).show();
            }
        });

//Appointment
        appointment = findViewById(R.id.appointment_textView);
        appointment.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RequestActivity.class);
                startActivity(intent);

                Toast.makeText(MainActivity.this, "You clicked on appointment", Toast.LENGTH_SHORT).show();
            }
        });
    }


}