package com.jahid.productratings.book;

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
import com.jahid.productratings.WebActivity;
import com.jahid.productratings.model.Function;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.List;

public class BookAnalysisAdapter extends RecyclerView.Adapter<BookAnalysisAdapter.ViewHolder> {


    private Context context;
    private List<BookAnalysis> listItems;
    private BookAnalysisAdapter adapter;

    public BookAnalysisAdapter(Context context, List<BookAnalysis> listItems) {
        this.context = context;
        this.listItems = listItems;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.book_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookAnalysisAdapter.ViewHolder holder, int position) {


        final BookAnalysis product = listItems.get(position);

        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);

        /*String boibazarRating = product.getBoibazarRating() ;
        String boibazarNoOfVote = product.getBoibazar_noOfRated();
        String rokomariRating = product.getRokomari_rating();
        String rokomariNoOfVote = product.getRokomari_noOfrated();*/

        //System.out.println(boibazarRating + " " + boibazarNoOfVote + " " + rokomariRating + " " + rokomariNoOfVote);

        Float totalBoizarRating = (Float.parseFloat(product.getBoibazarRating())* Float.parseFloat( product.getBoibazar_noOfRated()));
        Float totalRokomariRating = (Float.parseFloat(product.getRokomari_rating())* Float.parseFloat( product.getRokomari_noOfrated()));
        Float total_vote =Float.parseFloat( product.getBoibazar_noOfRated()) + Float.parseFloat(product.getRokomari_noOfrated());

        System.out.println(totalBoizarRating + " " + totalRokomariRating + " " + total_vote);

        // calculation equation
        float total_rating = ((totalBoizarRating + totalRokomariRating)/total_vote)*20;

        Picasso.with(context).load(product.getImage()).into(holder.imageView);
        holder.title.setText(product.getTitle()+"\n"+ product.getAuthor());
        holder.title.setTextSize(15);
        holder.our_rating.setText(String.valueOf(df.format(total_rating)));
       // System.out.println("flipcart rating: " + product.getFlipkart_rating());
        holder.walmart_text.setText("Boibazar Rating: " + product.getBoibazarRating());
        holder.flipkart_text.setText("Rokomari Rating: " + product.getRokomari_rating());
        holder.score.setText("Review score: "+String.valueOf(product.getScore()+1));

        String boibazar_price = String.valueOf(product.getBoibazar_price());
        String rokonari_price = String.valueOf(product.getRokomari_price());

        /*String[] words = f_price.split(",");//splits the string based on whitespace
        //using java foreach loop to print elements of string array
        for (String w : words) {
            System.out.println(w);
        }
        String title = words[0]+ words[1];
        System.out.println("price : "+title);
        float flipkart_Price = Float.parseFloat(title);*/


        String[] spinnerArray = {"Go To Shop","Boibazar.com  \t" + boibazar_price, "Rokomari.com \t" +rokonari_price};
        String[] SA = {"yes","no"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_dropdown_item, spinnerArray);
        //adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        holder.spinner.setAdapter(adapter);
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public ImageView imageView;
        public TextView title;
        public TextView our_rating;
        public TextView walmart_text;
        public TextView flipkart_text;
        public TextView score;
        public Spinner spinner;


        public ViewHolder(View itemView) {
            super(itemView);

             itemView.setOnClickListener( this);

            imageView = (ImageView) itemView.findViewById(R.id.mobile_image);
            title = (TextView) itemView.findViewById(R.id.title);
            our_rating = (TextView) itemView.findViewById(R.id.our_rating);
            walmart_text = (TextView) itemView.findViewById(R.id.walmart_text);
            flipkart_text = (TextView) itemView.findViewById(R.id.flipkart_text);
            spinner = (Spinner) itemView.findViewById(R.id.price);
            score = (TextView) itemView.findViewById(R.id.score);

            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {


                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            });
        }


        @Override
        public void onClick(View view) {
            //Get position of the row clicked or tapped
            int position = getAdapterPosition();

            int code = spinner.getSelectedItemPosition();

            BookAnalysis item = listItems.get(position);
            if (Function.isNetworkAvailable(context)) {


                Intent intent = new Intent(context, WebActivity.class);

                if (code == 1) {
                    intent.putExtra("address", item.getBoibazar_url());
                    context.startActivity(intent);
                }
                if (code == 2){
                    if(item.getRokomari_url().contains(".com")){
                        intent.putExtra("address", item.getRokomari_url());
                        context.startActivity(intent);
                    } else
                        Toast.makeText(context,"Information is not available",Toast.LENGTH_SHORT).show();

                }


            } else {
                Toast.makeText(context, "No Internet Connection", Toast.LENGTH_LONG).show();
            }

        }
    }
}
