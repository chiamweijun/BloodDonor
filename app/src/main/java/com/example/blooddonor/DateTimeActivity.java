package com.example.blooddonor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class DateTimeActivity extends AppCompatActivity {

    private EditText mMessageDate;
    private EditText mMessageTime;

    LinearLayout request;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_time);

        mMessageDate = findViewById(R.id.date_text);
        mMessageTime = findViewById(R.id.time_text);
    }

    public void showDatePickerDialog(View view) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), getString(R.string.datePicker));
    }

    public void processDatePickerResult(int year, int month, int day) {
        String month_string = Integer.toString(month + 1);
        String day_string = Integer.toString(day);
        String year_string = Integer.toString(year);
        String dateMessage = (month_string + "/" + day_string + "/" + year_string);

        EditText mDateEditText = findViewById(R.id.date_text);
        mDateEditText.setText(dateMessage);
    }

    public void processTimePickerResult(int hourOfDay, int minute) {
        String hour_string = Integer.toString(hourOfDay);
        String minute_string = Integer.toString(minute);
        // Assign the concatenated strings to timeMessage.
        String timeMessage = (hour_string + ":" + minute_string);

        EditText mDateEditText = findViewById(R.id.time_text);
        mDateEditText.setText(timeMessage);
    }

    public void showTimePickerDialog(View view) {
        DialogFragment newFragment = new TimePickerFragment();
        newFragment.show(getSupportFragmentManager(), getString(R.string.timePicker));
    }

    public void NextActivity(View view) {
        Intent intent = new Intent(this, ConfirmationActivity.class);

        String mName = mMessageDate.getText().toString();
        intent.putExtra("name", mName);

        String mPhone = mMessageTime.getText().toString();
        intent.putExtra("phone", mPhone);

        startActivity(intent);
    }
}