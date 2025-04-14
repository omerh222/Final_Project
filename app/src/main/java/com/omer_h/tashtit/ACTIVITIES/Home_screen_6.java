package com.omer_h.tashtit.ACTIVITIES;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.omer_h.tashtit.R;

public class Home_screen_6 extends AppCompatActivity {
    ImageButton burgerMenu;
    ImageButton deleteButton;
    ImageButton upButton;
    ImageButton downButton;
    TextView title;
    ImageButton searchButton;
    RecyclerView recyclerView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home_screen6);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        initializeViews();
        setListeners();
        setViewModel();
        setRecyclerView();
    }

    private void setRecyclerView() {
        // Set up the RecyclerView here

    }

    private void setViewModel() {
    }

    private void setListeners() {
        burgerMenu.setOnClickListener(v -> {
            // Handle burger menu click
        });
        deleteButton.setOnClickListener(v -> {
            // Handle delete button click
        });
        upButton.setOnClickListener(v -> {
            // Handle up button click
        });
        downButton.setOnClickListener(v -> {
            // Handle down button click
        });
        searchButton.setOnClickListener(v -> {
            // Handle search button click
        });
    }

    private void initializeViews() {
        // Initialize views here
        burgerMenu = findViewById(R.id.btnMenu);
        deleteButton = findViewById(R.id.ibDelete);
        upButton = findViewById(R.id.ibUp);
        downButton = findViewById(R.id.ibBurger);
        title = findViewById(R.id.tvTitle);
        recyclerView = findViewById(R.id.rvMedicines);
    }
}