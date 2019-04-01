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
import com.jahid.productratings.book.Book;
import com.jahid.productratings.book.BookAdapter;
import com.jahid.productratings.product.Product;
import com.jahid.productratings.product.ProductAdapter;

import java.util.ArrayList;
import java.util.List;

public class ProductActivityBook extends AppCompatActivity {

    FirebaseDatabase database;
    DatabaseReference myRef;

    RecyclerView recyclerView;
    List<Book> mobileList;
    private RecyclerView.Adapter adapter;
    String[] mTitle;

    String title;
    String imageUrl;
    String author;
    String boibazar_noOfRated;
    String boibazar_price;
    String boibazarRating;
    String boibazar_url;
    String rokomari_noOfrated;
    String rokomari_price;
    String rokomari_rating;
    String rokomari_url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        recyclerView = (RecyclerView) findViewById(R.id.list_id);

        mobileList = new ArrayList<>();

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("book");

        System.out.println("reference: " + myRef);

        String image = "https://s3-ap-southeast-1.amazonaws.com/rokomari110/productNew/260X372/2b532fb15_178414.jpg";
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

                    title = brandSnapshot.child("title").getValue(String.class);
                    author = brandSnapshot.child("author").getValue(String.class);
                    imageUrl = brandSnapshot.child("image").getValue(String.class);
                    boibazar_price = brandSnapshot.child("boibazar_price").getValue(String.class);
                    boibazar_noOfRated = brandSnapshot.child("boibazar_noOfRated").getValue(String.class);
                    boibazarRating = brandSnapshot.child("boibazar_rating").getValue(String.class);
                    boibazar_url = brandSnapshot.child("boibazar_url").getValue(String.class);
                    rokomari_url = brandSnapshot.child("rokomari_url").getValue(String.class);
                    rokomari_price = brandSnapshot.child("rokomari_price").getValue(String.class);
                    rokomari_rating = brandSnapshot.child("rokomari_rating").getValue(String.class);
                    rokomari_noOfrated = brandSnapshot.child("rokomari_noOfrated").getValue(String.class);


                    Log.e(dataSnapshot.getKey(), dataSnapshot.getChildrenCount() + "");

                    Book product4 = new Book(title, author,
                            boibazar_noOfRated, boibazar_price, boibazarRating, boibazar_url,
                            imageUrl, rokomari_noOfrated, rokomari_price, rokomari_rating,rokomari_url);
                    //System.out.println("Title: " + words);
                    mobileList.add(product4);
                    //mobileList.add(product);

                }
                adapter = new BookAdapter(getApplicationContext(), mobileList);
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
