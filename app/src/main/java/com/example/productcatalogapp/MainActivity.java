package com.example.productcatalogapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.SearchView;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Button addButton;
    private Button sortButton;
    public static List<Product> productList = new ArrayList<>();

    private SearchView searchView;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchView = findViewById(R.id.productSearch);
        searchView.clearFocus();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

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
        sortButton = findViewById(R.id.sortButton);
        addButton = findViewById(R.id.addButton);

        addButton.setOnClickListener(v -> {
            Intent intent = new Intent(this, AddEditOne.class);
            startActivity(intent);
        });

        sortButton.setOnClickListener(v -> {
            sortProductList();
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });
    }

    private void sortProductList() {
        for (int i = 0, n = productList.size(); i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                double current = productList.get(j).getPrice();
                double next = productList.get(j + 1).getPrice();
                if (current > next) {
                    Product temp = productList.get(j);
                    productList.set(j, productList.get(j + 1));
                    productList.set(j + 1, temp);
                }
            }
        }
    }
}