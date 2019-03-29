package com.jahid.productratings;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

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

public class ProductActivity extends AppCompatActivity {

    FirebaseDatabase database;
    DatabaseReference myRef;

    RecyclerView recyclerView;
    List<Product> mobileList;
    private RecyclerView.Adapter adapter;
    String[] mTitle;
    String title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        recyclerView = (RecyclerView) findViewById(R.id.list_id);

        mobileList = new ArrayList<>();

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("mobile");

        System.out.println("reference: " + myRef);

        String image = "https://s3-ap-southeast-1.amazonaws.com/rokomari110/productNew/260X372/2b532fb15_178414.jpg";

        /*Product product1 = new Product("Mobile", "https://s3-ap-southeast-1.amazonaws.com/rokomari110/productNew/260X372/2b532fb15_178414.jpg",
                32.0f, 5.0f, 5.0f, "walmart",
                33.0f, 5.0f, 5.0f, "flip");
        Product product2 = new Product("Mobile", "https://s3-ap-southeast-1.amazonaws.com/rokomari110/productNew/260X372/2b532fb15_178414.jpg",
                32.0f, 1.0f, 5.0f, "walmart",
                33.0f, 5.0f, 5.0f, "flip");
        Product product3 = new Product("Mobile", "https://s3-ap-southeast-1.amazonaws.com/rokomari110/productNew/260X372/2b532fb15_178414.jpg",
                32.0f, 3.0f, 5.0f, "walmart",
                33.0f, 4.0f, 5.0f, "flip");
        Product product4 = new Product("Mobile", "https://s3-ap-southeast-1.amazonaws.com/rokomari110/productNew/260X372/2b532fb15_178414.jpg",
                32.0f, 2.0f, 5.0f, "walmart",
                33.0f, 4.0f, 5.0f, "flip");
        mobileList.add(product1);
        mobileList.add(product2);
        mobileList.add(product3);
        mobileList.add(product4);*/

        /*adapter = new ProductAdapter(this, mobileList);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));*/
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

                    System.out.println("Product: " + product);

                    title = brandSnapshot.child("Title").getValue(String.class);

                    Log.e(dataSnapshot.getKey(),dataSnapshot.getChildrenCount() + "");

                    //String s  =String.valueOf(mPrice);
                    String[] words=title.split("\\s");//splits the string based on whitespace
                    //using java foreach loop to print elements of string array
                    for(String w:words){
                        System.out.println(w);
                    }
                    String title = words[0]+" "+words[1]+" "+words[2]+" "+words[3];
                    //System.out.println(s);
                    Product product4 = new Product(title, "https://s3-ap-southeast-1.amazonaws.com/rokomari110/productNew/260X372/2b532fb15_178414.jpg",
                            32.0f, 2.0f, 5.0f, "walmart",
                            33.0f, 4.0f, 5.0f, "flip");
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
