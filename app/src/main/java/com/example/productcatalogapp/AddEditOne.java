package com.example.productcatalogapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class AddEditOne extends AppCompatActivity {
    private Button createButton;
    private Button cancelButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit_one);

        createButton = findViewById(R.id.createButton);
        cancelButton = findViewById(R.id.cancelButton);

        setButtons();
    }

    private void setButtons() {
        createButton.setOnClickListener(v -> {

        });

        cancelButton.setOnClickListener(v -> {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });
    }
}