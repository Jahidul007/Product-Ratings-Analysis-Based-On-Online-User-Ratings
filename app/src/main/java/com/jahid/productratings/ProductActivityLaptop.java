package com.jahid.productratings;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.jahid.productratings.laptop.Laptop;
import com.jahid.productratings.laptop.LaptopAdapter;
import com.jahid.productratings.product.Product;
import com.jahid.productratings.product.ProductAdapter;

import java.util.ArrayList;
import java.util.List;

public class ProductActivityLaptop extends AppCompatActivity {

    FirebaseDatabase database;
    DatabaseReference myRef;

    RecyclerView recyclerView;
    List<Laptop> laptopList;
    private RecyclerView.Adapter adapter;
    String[] mTitle;

    String title;
    String imageUrl;
    String walmart_price;
    String walmart_link;
    float walmart_rating;
    float walmart_voted;
    String amazon_link;
    String amazon_price;
    float amazon_rating;
    float amazon_voted;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        recyclerView = (RecyclerView) findViewById(R.id.list_id);

        laptopList = new ArrayList<>();

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("laptop");

        System.out.println("reference: " + myRef);

        String image = "https://s3-ap-southeast-1.amazonaws.com/rokomari110/productNew/260X372/2b532fb15_178414.jpg";


    }
    @Override
    protected void onStart() {
        super.onStart();

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                laptopList.clear();

                for (DataSnapshot brandSnapshot : dataSnapshot.getChildren()) {

                    Product product = brandSnapshot.getValue(Product.class);

                    System.out.println("Laptop: " + product);

                    title = brandSnapshot.child("Title").getValue(String.class);
                    imageUrl = brandSnapshot.child("Image").getValue(String.class);
                    walmart_price = brandSnapshot.child("Price").getValue(String.class);
                    walmart_link = brandSnapshot.child("Link").getValue(String.class);
                    walmart_rating = brandSnapshot.child("Rating").getValue(Float.class);
                    walmart_voted = brandSnapshot.child("Voted").getValue(Float.class);
                    amazon_link = brandSnapshot.child("Amazon Link").getValue(String.class);
                    amazon_price = brandSnapshot.child("Amazon Price").getValue(String.class);
                    amazon_rating = brandSnapshot.child("Amazon Rating").getValue(Float.class);
                    amazon_voted = brandSnapshot.child("Amazon Voted").getValue(Float.class);

                    Log.e(dataSnapshot.getKey(),dataSnapshot.getChildrenCount() + "");

                    //String s  =String.valueOf(mPrice);
                    String[] words=title.split("\\s");//splits the string based on whitespace
                    //using java foreach loop to print elements of string array
                    for(String w:words){
                        System.out.println(w);
                    }
                    String title = words[0]+" "+words[1]+" "+words[2]+" "+words[3];
                    //System.out.println(s);
                    Laptop laptop = new Laptop(title, imageUrl,
                            walmart_price, walmart_rating, walmart_rating, walmart_link,
                            amazon_price, amazon_rating, amazon_voted, amazon_link);
                    System.out.println("Title: " + words);
                    laptopList.add(laptop);
                    //mobileList.add(product);

                }
                adapter = new LaptopAdapter(getApplicationContext(), laptopList);
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
