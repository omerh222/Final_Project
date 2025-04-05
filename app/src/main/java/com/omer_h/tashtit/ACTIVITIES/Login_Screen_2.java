package com.omer_h.tashtit.ACTIVITIES;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.omer_h.helper.inputValidators.Rule;
import com.omer_h.helper.inputValidators.RuleOperation;
import com.omer_h.helper.inputValidators.Validator;
import com.omer_h.tashtit.R;

public class Login_Screen_2 extends AppCompatActivity implements View.OnClickListener {
    Button loginButton;
    ImageButton backButtonLogin;
    EditText etEmail;
    EditText etPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login_screen2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        initializeViews();
        setListeners();
        setValidator();
    }

    protected void initializeViews()
    {
        backButtonLogin=findViewById(R.id.btnBackLogin);
        loginButton = findViewById(R.id.btnLoginLogin);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
    }
    protected void setListeners() {
        loginButton.setOnClickListener(this);
        backButtonLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v==loginButton)
            if(validate())
            {
                Intent intent = new Intent(Login_Screen_2.this, Home_screen_6.class);
                startActivity(intent);
            }
        if(v==backButtonLogin)
            finish();
    }

    private boolean validate(){
        return Validator.validate();
    }

    public void setValidator(){
        Validator.add(new Rule(etEmail, RuleOperation.REQUIRED, "Please enter your email"));
        Validator.add(new Rule(etPassword, RuleOperation.REQUIRED, "Please enter you password"));
    }//can i compare the saved password with the entered password in the validator?


}