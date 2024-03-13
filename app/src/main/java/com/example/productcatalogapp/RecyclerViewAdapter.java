package com.example.productcatalogapp;

import android.content.Context;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {
    private List<Product> productList;
    private Context context;

    public RecyclerViewAdapter(List<Product> productList, Context context) {
        this.productList = productList;
        this.context = context;
    }

    class MyViewHolder {
        private int id;
        private String name;
        private String description;
        private double price;
    }
}
