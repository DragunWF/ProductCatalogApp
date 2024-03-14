package com.example.productcatalogapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Button addButton;
    public static List<Product> productList = new ArrayList<>();

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createRecyclerView();
        if (productList.size() == 0) {
            fillProductList();
        }

        setButtons();
    }

    private void createRecyclerView() {
        // Recycler View Set Up
        recyclerView = findViewById(R.id.productListRecycler);
        recyclerView.setHasFixedSize(true);

        // Recycler View Layout
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // Recycler View Adapter
        adapter = new RecyclerViewAdapter(productList); // my own class
        recyclerView.setAdapter(adapter);
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
        addButton = findViewById(R.id.addButton);
        addButton.setOnClickListener(v -> {
            Intent intent = new Intent(this, AddEditOne.class);
            startActivity(intent);
        });
    }
}