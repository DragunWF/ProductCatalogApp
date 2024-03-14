package com.example.productcatalogapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class AddEditOne extends AppCompatActivity {
    private Button createButton;
    private Button cancelButton;
    private EditText editTextProductName;
    private EditText editTextProductDescription;
    private EditText editTextProductPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit_one);

        createButton = findViewById(R.id.createButton);
        cancelButton = findViewById(R.id.cancelButton);

        editTextProductName = findViewById(R.id.editTextProductName);
        editTextProductDescription = findViewById(R.id.editTextProductDescription);
        editTextProductPrice = findViewById(R.id.editTextProductPrice);

        setButtons();
    }

    private void setButtons() {
        createButton.setOnClickListener(v -> {
            MainActivity.productList.add(
                    new Product(
                            1,
                            String.valueOf(editTextProductName.getText()),
                            String.valueOf(editTextProductDescription.getText()),
                            Double.parseDouble(String.valueOf(editTextProductPrice.getText()))
                    )
            );
            switchViews();
        });

        cancelButton.setOnClickListener(v -> {
            switchViews();
        });
    }

    private void switchViews() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}