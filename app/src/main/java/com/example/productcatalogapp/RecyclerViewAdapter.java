package com.example.productcatalogapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.ArrayList;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private final List<Product> localDataSet;

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder)
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView productImage;
        private TextView nameText;
        private TextView descriptionText;
        private TextView priceText;

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View

            productImage = view.findViewById(R.id.productImage);
            nameText = view.findViewById(R.id.productNameText);
            descriptionText = view.findViewById(R.id.productDescriptionText);
            priceText = view.findViewById(R.id.productPriceText);
        }

        public ImageView getProductImage() {
            return productImage;
        }

        public TextView getNameText() {
            return nameText;
        }

        public TextView getDescriptionText() {
            return descriptionText;
        }

        public TextView getPriceText() {
            return priceText;
        }
    }

    /**
     * Initialize the dataset of the Adapter
     *
     * @param dataSet String[] containing the data to populate views to be used
     * by RecyclerView
     */
    public RecyclerViewAdapter(List<Product> dataSet) {
        localDataSet = dataSet;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.one_line_product, viewGroup, false);

        return new ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.getProductImage().setImageResource(R.drawable.ic_launcher_background);
        viewHolder.getNameText().setText(localDataSet.get(position).getName());
        viewHolder.getDescriptionText().setText(localDataSet.get(position).getDescription());
        viewHolder.getPriceText().setText(localDataSet.get(position).getPrice() + " PHP");
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return localDataSet.size();
    }
}

