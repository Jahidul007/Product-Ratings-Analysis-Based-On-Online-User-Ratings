package com.jahid.productratings;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.jahid.productratings.R;
import com.jahid.productratings.category.Category;
import com.jahid.productratings.product.Product;
import com.jahid.productratings.product.ProductAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<Product> mobileList;
    private RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        recyclerView = (RecyclerView) findViewById(R.id.list_id);

        mobileList = new ArrayList<>();
        String image = "https://s3-ap-southeast-1.amazonaws.com/rokomari110/productNew/260X372/2b532fb15_178414.jpg";

        Product product1 = new Product("Mobile", "https://s3-ap-southeast-1.amazonaws.com/rokomari110/productNew/260X372/2b532fb15_178414.jpg",
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
        mobileList.add(product4);

        adapter = new ProductAdapter(this, mobileList);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
