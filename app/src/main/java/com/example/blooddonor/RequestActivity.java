package com.example.blooddonor;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class RequestActivity extends AppCompatActivity implements
        AdapterView.OnItemSelectedListener {

    public static final String EXTRA_MESSAGE = "com.example.android.twoactivities.extra.MESSAGE";

    private EditText mMessageName;
    private EditText mMessagePhone;
    private EditText mMessageAddress;
    private EditText mMessageEmail;
    private EditText mMessageDateBirth;

    private RadioButton male;
    private RadioButton female;
    private String selectedTypeGender="";

    private RadioButton typeA;
    private RadioButton typeB;
    private RadioButton typeAB;
    private RadioButton typeO;
    private String selectedTypeBlood="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request);

//State Spinner
        Spinner spinner = findViewById(R.id.state_spinner);
        spinner.setOnItemSelectedListener(this);
        List<String> label_array = new ArrayList<>();
        label_array.add("Kuala Lumpur");
        label_array.add("Putrajaya");
        label_array.add("Negeri Sembilan");
        label_array.add("Johor");
        label_array.add("Kedah");
        label_array.add("Pahang");
        label_array.add("Selangor");
        label_array.add("Kelantan");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, label_array);
        dataAdapter.setDropDownViewResource
                (android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);

//radioGroupGender
        RadioGroup gender = (RadioGroup) findViewById(R.id.radioGroupGender);
        male = (RadioButton) findViewById(R.id.button_female);
        female = (RadioButton) findViewById(R.id.button_male);
        female.setSelected(true);
        gender.setOnCheckedChangeListener((radioGroup, i) -> {
            if (i == R.id.button_female) {
                selectedTypeGender = female.getText().toString();
            } else {
                selectedTypeGender = male.getText().toString();
            }
        });

//radioGroupBlood
        RadioGroup blood = (RadioGroup) findViewById(R.id.radioGroupBlood);
        typeA = (RadioButton) findViewById(R.id.A_blood_type);
        typeB = (RadioButton) findViewById(R.id.B_blood_type);
        typeAB = (RadioButton) findViewById(R.id.AB_blood_type);
        typeO = (RadioButton) findViewById(R.id.O_blood_type);
        typeA.setSelected(true);
        blood.setOnCheckedChangeListener((radioGroup, i) -> {
            if (i == R.id.A_blood_type) {
                selectedTypeBlood = typeA.getText().toString();
            } else if (i == R.id.B_blood_type){
                selectedTypeBlood = typeB.getText().toString();
            } else if (i == R.id.AB_blood_type){
                selectedTypeBlood = typeAB.getText().toString();
            } else{
                selectedTypeBlood = typeO.getText().toString();
            }
        });

//Name/Phone/Address/Email/Date
    mMessageName = findViewById(R.id.name_text);
    mMessagePhone = findViewById(R.id.phone_text);
    mMessageAddress = findViewById(R.id.address_text);
    mMessageEmail = findViewById(R.id.email_text);
    mMessageDateBirth = findViewById(R.id.datebirth_text);

}
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        String item = parent.getItemAtPosition(position).toString();

        // Showing selected spinner item
        Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
    }

    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }

    //RadioButton
    public void displayToast (String message){
        Toast.makeText(getApplicationContext(), message,
                Toast.LENGTH_SHORT).show();
    }

    @SuppressLint("NonConstantResourceId")
    public void onItemSelected(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        // Check which radio button was clicked.
        switch (view.getId()) {
            case R.id.button_female:
                if (checked)
                    // Same day service
                    displayToast(getString(R.string.female));
                break;
            case R.id.button_male:
                if (checked)
                    // Next day delivery
                    displayToast(getString(R.string.male));
                break;
            case R.id.A_blood_type:
                if (checked)
                    // Next day delivery
                    displayToast(getString(R.string.a));
                break;
            case R.id.B_blood_type:
                if (checked)
                    // Next day delivery
                    displayToast(getString(R.string.b));
                break;
            case R.id.AB_blood_type:
                if (checked)
                    // Next day delivery
                    displayToast(getString(R.string.ab));
                break;
            case R.id.O_blood_type:
                if (checked)
                    // Next day delivery
                    displayToast(getString(R.string.o));
                break;
            default:
                // Do nothing.
                break;
        }
    }

    public void ConfirmationActivity(View view) {
        Toast toast = Toast.makeText(this, R.string.toast_message,
                Toast.LENGTH_SHORT);
        toast.show();

//Name/Phone/Address/Email/Date
        Intent intent = new Intent(this, ConfirmationActivity.class);
        String mName = mMessageName.getText().toString();
        intent.putExtra("name", mName);

        String mPhone = mMessagePhone.getText().toString();
        intent.putExtra("phone", mPhone);

        String mAddress = mMessageAddress.getText().toString();
        intent.putExtra("address", mAddress);

        String mEmail = mMessageEmail.getText().toString();
        intent.putExtra("phone", mEmail);

        String mDateBirth = mMessageDateBirth.getText().toString();
        intent.putExtra("datebirth", mDateBirth);

//RadioGroup
        intent.putExtra(EXTRA_MESSAGE,selectedTypeGender);
        intent.putExtra(EXTRA_MESSAGE,selectedTypeBlood);

//Spinner
        Spinner spinner = findViewById(R.id.state_spinner);
        spinner.setOnItemSelectedListener(this);
        intent.putExtra("data", String.valueOf(spinner.getSelectedItem()));

        startActivity(intent);

    }
}