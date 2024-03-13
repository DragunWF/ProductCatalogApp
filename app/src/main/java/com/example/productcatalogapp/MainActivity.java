package com.example.productcatalogapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {
    private Button addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addButton = findViewById(R.id.addButton);

        setButtons();
    }

    private void setButtons() {
        addButton.setOnClickListener(v -> {
            Intent intent = new Intent(this, AddEditOne.class);
            startActivity(intent);
        });
    }
}