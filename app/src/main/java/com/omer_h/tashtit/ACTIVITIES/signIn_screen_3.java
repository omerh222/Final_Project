package com.omer_h.tashtit.ACTIVITIES;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.omer_h.helper.inputValidators.Rule;
import com.omer_h.helper.inputValidators.RuleOperation;
import com.omer_h.helper.inputValidators.Validator;
import com.omer_h.tashtit.R;

public class signIn_screen_3 extends AppCompatActivity implements View.OnClickListener {
    EditText firstName;
    EditText lastName;
    EditText email;
    EditText phone;
    EditText password;
    EditText emergencyNumber;
    Spinner age;
    Button allergens;
    ImageButton backButton;
    Button signInButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_signin_screen3);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        initializeViews();
        setListeners();
        setValidator();
    }

    private void initializeViews() {
        firstName = findViewById(R.id.etFirstName);
        lastName = findViewById(R.id.etLastName);
        email = findViewById(R.id.etEmailSignIn);
        phone = findViewById(R.id.etPhone);
        password = findViewById(R.id.etPasswordSignIn);
        emergencyNumber = findViewById(R.id.etEmergencyNum);
        age = findViewById(R.id.spnnrAge);
        allergens = findViewById(R.id.btnAllergens);
        backButton = findViewById(R.id.btnBackSignIn);
        signInButton = findViewById(R.id.btnSignInSignIn);
    }

    private boolean validate() {
        return Validator.validate();
    }

    private void setValidator() {
        Validator.add(new Rule(firstName, RuleOperation.REQUIRED, "Please enter your first name"));
        Validator.add(new Rule(lastName, RuleOperation.REQUIRED, "Please enter you last name"));
        Validator.add(new Rule(email, RuleOperation.REQUIRED, "Please enter your email"));
        Validator.add(new Rule(password, RuleOperation.REQUIRED, "Please enter you password"));
        Validator.add(new Rule(phone, RuleOperation.REQUIRED, "Please enter your phone number"));
        Validator.add(new Rule(emergencyNumber, RuleOperation.REQUIRED, "Please enter your emergency number"));
    }

    private void setListeners() {
        backButton.setOnClickListener(this);
        signInButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v==backButton){
            finish();
        }
        if(v==signInButton){
            if(validate()){
                Intent intent = new Intent(signIn_screen_3.this, Home_screen_6.class);
                startActivity(intent);
            }
        }
    }
}