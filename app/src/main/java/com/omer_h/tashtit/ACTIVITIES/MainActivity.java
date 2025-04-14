package com.omer_h.tashtit.ACTIVITIES;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.omer_h.tashtit.R;

import androidx.activity.EdgeToEdge;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.omer_h.tashtit.ACTIVITIES.BASE.BaseActivity;

public class MainActivity extends BaseActivity implements View.OnClickListener {
    Button loginButton;
    Button signInButton;
    TextView textViewResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        //setContentView(R.layout.activity_main);
        getLayoutInflater().inflate(R.layout.activity_main, findViewById(R.id.content_frame));
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        initializeViews();
    }



    @Override
    protected void initializeViews() {
        loginButton = findViewById(R.id.btnLoginLogin);
        signInButton = findViewById(R.id.signInButton);
        textViewResult = findViewById(R.id.textViewResult);
        setListeners();
    }

    @Override
    protected void setListeners() {
        loginButton.setOnClickListener(this);
        signInButton.setOnClickListener(this);
    }

    @Override
    protected void setViewModel() {

    }

    @Override
    public void onClick(View v) {
        if(v==loginButton) {
            Intent intent = new Intent(MainActivity.this, Login_Screen_2.class);
            startActivity(intent);
        }
        if(v==signInButton) {
            Intent intent = new Intent(MainActivity.this, signUp_screen_3.class);
            startActivity(intent);
        }

    }
}