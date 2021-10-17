package com.example.blooddonor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ConfirmationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation);

        Intent intent = getIntent();

        TextView mMessageName = findViewById(R.id.message_name);
        TextView mMessagePhone = findViewById(R.id.message_phone);
        TextView mMessageAddress = findViewById(R.id.message_address);
        TextView mMessageEmail = findViewById(R.id.message_email);
        TextView mMessageDateBirth = findViewById(R.id.message_datebirth);
        TextView mMessageDate = findViewById(R.id.date_text);
        TextView mMessageTime = findViewById(R.id.time_text);


        String name = getIntent().getStringExtra("name");
        String phone = getIntent().getStringExtra("phone");
        String address = getIntent().getStringExtra("address");
        String email = getIntent().getStringExtra("email");
        String datebirth = getIntent().getStringExtra("datebirth");
        String date = getIntent().getStringExtra("date");
        String time = getIntent().getStringExtra("time");

        mMessageName.setText(name);
        mMessagePhone.setText(phone);
        mMessageAddress.setText(address);
        mMessageEmail.setText(email);
        mMessageDate.setText(datebirth);
        mMessageDate.setText(date);
        mMessageTime.setText(time);

        TextView state = findViewById(R.id.message_state);
        Bundle bundle=getIntent().getExtras();
        String data=bundle.get("data").toString();
        state.setText(data);

        String selectTypeGender = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView gender = findViewById(R.id.message_gender);
        gender.setText(selectTypeGender);

        String selectTypeBlood = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView blood = findViewById(R.id.message_blood);
        blood.setText(selectTypeBlood);
    }

}