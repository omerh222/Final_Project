package com.omer_h.tashtit.ACTIVITIES;

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
import androidx.lifecycle.ViewModelProvider;

import com.omer_h.helper.inputValidators.Rule;
import com.omer_h.helper.inputValidators.RuleOperation;
import com.omer_h.helper.inputValidators.Validator;
import com.omer_h.model.Allergens;
import com.omer_h.model.PersonalInfo;
import com.omer_h.tashtit.R;
import com.omer_h.viewmodel.PersonalInfoViewModel;

public class signUp_screen_3 extends AppCompatActivity implements View.OnClickListener {
    EditText firstName;
    EditText lastName;
    EditText email;
    EditText phone;
    EditText password;
    EditText emergencyNumber;
    Spinner age;
    Button allergens;
    ImageButton backButton;
    Button signUpButton;
    PersonalInfo newUser;
    PersonalInfoViewModel viewModel;
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
        setViewModel();
        newUser = new PersonalInfo();
    }

    private void setViewModel() {//set the view model that put the new users into the database
        viewModel = new ViewModelProvider(this).get(PersonalInfoViewModel.class);
    }

    private void initializeViews() {//initialize the views
        firstName = findViewById(R.id.etFirstName);
        lastName = findViewById(R.id.etLastName);
        email = findViewById(R.id.etEmailSignIn);
        phone = findViewById(R.id.etPhone);
        password = findViewById(R.id.etPasswordSignIn);
        emergencyNumber = findViewById(R.id.etEmergencyNum);
        age = findViewById(R.id.spnnrAge);
        allergens = findViewById(R.id.btnAllergens);
        backButton = findViewById(R.id.btnBackSignIn);
        signUpButton = findViewById(R.id.btnSignInSignIn);
    }

    private boolean validate() {//checks that all the fields are filled
        return Validator.validate();
    }

    private void setValidator() {//checks that all the fields are filled
        Validator.add(new Rule(firstName, RuleOperation.REQUIRED, "Please enter your first name"));
        Validator.add(new Rule(lastName, RuleOperation.REQUIRED, "Please enter you last name"));
        Validator.add(new Rule(email, RuleOperation.REQUIRED, "Please enter your email"));
        Validator.add(new Rule(password, RuleOperation.REQUIRED, "Please enter you password"));
        Validator.add(new Rule(phone, RuleOperation.REQUIRED, "Please enter your phone number"));
        Validator.add(new Rule(emergencyNumber, RuleOperation.REQUIRED, "Please enter your emergency number"));
    }

    private void setListeners() {
        backButton.setOnClickListener(this);
        signUpButton.setOnClickListener(this);
        allergens.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v==backButton){//back to the main activity
            finish();
        }
        if(v== signUpButton){//gets the allergens (if exist) from the allergen intent and adds it and the other personal details to the new user
            if(validate()){
                Intent allergenIntent = getIntent();
                if(allergenIntent.hasExtra("Allergens")) {
                    newUser.setAllergens((Allergens) allergenIntent.getSerializableExtra("Allergens"));
                }
                newUser.setFirstName(firstName.getText().toString());
                newUser.setLastName(lastName.getText().toString());
                newUser.setEmail(email.getText().toString());
                newUser.setPassword(password.getText().toString());
                newUser.setEmergencyNum(emergencyNumber.getText().toString());
                newUser.setBirthDate(Long.parseLong(age.getSelectedItem().toString()));
                viewModel.add(newUser);
                //add entering the new data to the database
                Intent intent = new Intent(signUp_screen_3.this, Login_Screen_2.class);
                startActivity(intent);
            }
        }
        if(v==allergens){//starts the allergen activity
            Intent intent = new Intent(signUp_screen_3.this, Allergens_screen4.class);
            intent.putExtra("userIdFs", newUser.getIdFs());
            startActivity(intent);
        }
    }
}