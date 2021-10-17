package com.example.blooddonor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class DonateActivity extends AppCompatActivity {

    private EditText mLocationEditText1;
    private EditText mLocationEditText2;
    private EditText mLocationEditText3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donate);

        mLocationEditText1=findViewById(R.id.location1_open);

        mLocationEditText2=findViewById(R.id.location2_open);

        mLocationEditText3=findViewById(R.id.location3_open);
    }

    //Location 1
    public void openLocation1(View view) {
        // Get the string indicating a location. Input is not validated; it is
        // passed to the location handler intact.
        String loc1 = mLocationEditText1.getText().toString();
        // Parse the location and create the intent.
        Uri addressUri1 = Uri.parse("geo:0,0?q=" + loc1);
        Intent intent1 = new Intent(Intent.ACTION_VIEW, addressUri1);
        // Find an activity to handle the intent, and start that activity.
        if (intent1.resolveActivity(getPackageManager()) != null) {
            startActivity(intent1);
        } else {
            Log.d("ImplicitIntents", "Can't handle this intent!");
        }
    }
    //Location 2
    public void openLocation2(View view) {

        String loc2 = mLocationEditText2.getText().toString();
        Uri addressUri2 = Uri.parse("geo:0,0?q=" + loc2);
        Intent intent2 = new Intent(Intent.ACTION_VIEW, addressUri2);
        if (intent2.resolveActivity(getPackageManager()) != null) {
            startActivity(intent2);
        } else {
            Log.d("ImplicitIntents", "Can't handle this intent!");
        }
    }

    //Location 3
    public void openLocation3(View view) {

        String loc3 = mLocationEditText3.getText().toString();
        Uri addressUri3 = Uri.parse("geo:0,0?q=" + loc3);
        Intent intent3 = new Intent(Intent.ACTION_VIEW, addressUri3);
        if (intent3.resolveActivity(getPackageManager()) != null) {
            startActivity(intent3);
        } else {
            Log.d("ImplicitIntents", "Can't handle this intent!");
        }
    }
}