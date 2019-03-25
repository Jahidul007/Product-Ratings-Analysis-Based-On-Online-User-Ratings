package com.jahid.productratings.product;

import android.app.LauncherActivity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.jahid.productratings.R;
import com.jahid.productratings.model.Function;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {


    private Context context;
    private List<Product> listItems;
    private ProductAdapter adapter;

    public ProductAdapter(Context context, List<Product> listItems) {
        this.context = context;
        this.listItems = listItems;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductAdapter.ViewHolder holder, int position) {


        Product product = listItems.get(position);

        float total_rating = (((product.getFlipkart_rating_no() * product.getFlipkart_rating())
                + (product.getWalmart_rating_no() * product.getWalmart_rating()))
                / (product.getWalmart_rating_no() + product.getFlipkart_rating_no())) * 20;

        Picasso.with(context).load(product.getImage()).into(holder.imageView);
        holder.title.setText(product.getTitle());
        holder.our_rating.setText(String.valueOf(total_rating));
        holder.walmart_text.setText("Walmart " + product.getWalmart_rating());
        holder.flipkart_text.setText("Flipkart " + product.getFlipkart_rating());

        String w_price = String.valueOf(product.getWalmart_price());
        String f_price = String.valueOf(product.getFlipkart_price());

        String[] spinnerArray = {"Walmart.com  \t$" + w_price, "Flipkart.com \t$" + f_price};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_item, spinnerArray);
        holder.spinner.setAdapter(adapter);

    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView imageView;
        public TextView title;
        public TextView our_rating;
        public TextView walmart_text;
        public TextView flipkart_text;
        public Spinner spinner;


        public ViewHolder(View itemView) {
            super(itemView);

            // itemView.setOnClickListener(this);

            imageView = (ImageView) itemView.findViewById(R.id.mobile_image);
            title = (TextView) itemView.findViewById(R.id.title);
            our_rating = (TextView) itemView.findViewById(R.id.our_rating);
            walmart_text = (TextView) itemView.findViewById(R.id.walmart_text);
            flipkart_text = (TextView) itemView.findViewById(R.id.flipkart_text);
            spinner = (Spinner) itemView.findViewById(R.id.price);

            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                    int selectedPosition = i;
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            });


        }


    }
}
