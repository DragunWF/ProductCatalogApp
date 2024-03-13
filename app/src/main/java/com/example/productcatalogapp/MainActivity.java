package com.example.productcatalogapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private final String TAG = "Products App";
    private Button addButton;
    private List<Product> productList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fillProductList();
        Log.d(TAG, String.format("onCreate: %s", productList.toString()));
        Log.d(TAG, String.valueOf(productList.size()));

        addButton = findViewById(R.id.addButton);

        setButtons();
    }

    private void fillProductList() {
        Product[] initialProducts = {
                new Product(1, "Apple", "One keeps the doctor away", 23.53),
                new Product(2, "Book", "Knowledge is power", 252.21),
                new Product(3, "Frying Pan", "It twas' quite famous in PUBG back at 2020", 153.12)
        };
        productList.addAll(Arrays.asList(initialProducts));
    }

    private void setButtons() {
        addButton.setOnClickListener(v -> {
            Intent intent = new Intent(this, AddEditOne.class);
            startActivity(intent);
        });
    }
}