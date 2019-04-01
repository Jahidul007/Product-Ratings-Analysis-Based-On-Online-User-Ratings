package com.jahid.productratings;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.jahid.productratings.R;
import com.jahid.productratings.category.Category;
import com.jahid.productratings.product.Product;
import com.jahid.productratings.product.ProductAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductActivityMobile extends AppCompatActivity {

    FirebaseDatabase database;
    DatabaseReference myRef;

    RecyclerView recyclerView;
    List<Product> mobileList;
    private RecyclerView.Adapter adapter;
    String[] mTitle;

    String title;
    String imageUrl;
    String walmart_price;
    String walmart_link;
    float walmart_rating;
    float walmart_voted;
    String flipkart_link;
    String flipkart_price;
    float flipkart_rating;
    float flipkart_voted;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        recyclerView = (RecyclerView) findViewById(R.id.list_id);

        mobileList = new ArrayList<>();

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("mobile");

        System.out.println("reference: " + myRef);

    }

    @Override
    protected void onStart() {
        super.onStart();

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                mobileList.clear();

                for (DataSnapshot brandSnapshot : dataSnapshot.getChildren()) {

                    Product product = brandSnapshot.getValue(Product.class);

                    System.out.println("Laptop: " + product);

                    title = brandSnapshot.child("Title").getValue(String.class);
                    imageUrl = brandSnapshot.child("Image").getValue(String.class);
                    walmart_price = brandSnapshot.child("Price").getValue(String.class);
                    walmart_link = brandSnapshot.child("Link").getValue(String.class);
                    walmart_rating = brandSnapshot.child("Rating").getValue(Float.class);
                    walmart_voted = brandSnapshot.child("Voted").getValue(Float.class);
                    flipkart_link = brandSnapshot.child("Flipkart Link").getValue(String.class);
                    flipkart_price = brandSnapshot.child("Flipkart Price").getValue(String.class);
                    flipkart_rating = brandSnapshot.child("Flipkart Rating").getValue(Float.class);
                    flipkart_voted = brandSnapshot.child("Flipkart voted").getValue(Float.class);


                    /*System.out.println("walmart price: " + walmart_price);
                    System.out.println("walmart link: " + walmart_link);
                    System.out.println("walmart rating: " + walmart_rating);
                    System.out.println("walmart vote: " + walmart_voted);
                    System.out.println("flipkart link: " + flipkart_link);
                    System.out.println("flipkart price: " + flipkart_price);
                    System.out.println("flipkart rating: " + flipkart_rating);
                    System.out.println("flipkart vote: " + flipkart_voted);*/

                    System.out.println();

                    Log.e(dataSnapshot.getKey(), dataSnapshot.getChildrenCount() + "");

                    //String s  =String.valueOf(mPrice);
                    String[] words = title.split("\\s");//splits the string based on whitespace
                    //using java foreach loop to print elements of string array
                    for (String w : words) {
                        System.out.println(w);
                    }
                    String title = words[0] + " " + words[1] + " " + words[2] + " " + words[3];
                    //System.out.println(s);
                    Product product4 = new Product(title, imageUrl, walmart_price, walmart_rating, walmart_voted, walmart_link,
                            flipkart_price, flipkart_rating, flipkart_voted, flipkart_link);
                    System.out.println("Title: " + words);
                    mobileList.add(product4);
                    //mobileList.add(product);

                }
                adapter = new ProductAdapter(getApplicationContext(), mobileList);
                recyclerView.setHasFixedSize(true);
                recyclerView.setAdapter(adapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

}
