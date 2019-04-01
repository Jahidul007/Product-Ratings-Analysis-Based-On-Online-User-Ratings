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
import com.jahid.productratings.product.Product;
import com.jahid.productratings.product.ProductAdapter;

import java.util.ArrayList;
import java.util.List;

public class ProductActivityBook extends AppCompatActivity {

    FirebaseDatabase database;
    DatabaseReference myRef;

    RecyclerView recyclerView;
    List<Product> mobileList;
    private RecyclerView.Adapter adapter;
    String[] mTitle;
    String title;
    String imageUrl;

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
                    imageUrl = brandSnapshot.child("image").getValue(String.class);


                    Log.e(dataSnapshot.getKey(), dataSnapshot.getChildrenCount() + "");

                    Product product4 = new Product(title, imageUrl,
                            "32.0f", 2.0f, 5.0f, "walmart",
                            "33.0f", 4.0f, 5.0f, "flip");
                    //System.out.println("Title: " + words);
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
