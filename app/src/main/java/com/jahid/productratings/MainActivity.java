package com.jahid.productratings;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;
import com.jahid.productratings.category.Category;
import com.jahid.productratings.category.CategoryAdapter;
import com.jahid.productratings.model.Function;
import com.jahid.productratings.model.MyKey;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,
        BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener {

    private Context context;
    private SliderLayout mDemoSlider;
    private ListView listView;

    List<Category> categoryList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mDemoSlider = (SliderLayout) findViewById(R.id.slider);
        listView = (ListView) findViewById(R.id.list_view);
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), ProductActivity.class);
                startActivity(intent);

            }
        });
        Button laptop = (Button) findViewById(R.id.buttonLaptop);
        laptop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), ProductActivityLaptop.class);
                startActivity(intent);

            }
        });

        /// List of product category
        /*String[] list = {"Mobile", "Laptop", "Camera", "Book", "Sun-glass", "Smartwatch", "Tablet", "Food"};
        List<String> stringList = Arrays.asList(list);
        categoryList = new ArrayList<>();


        for (int i = 0; i < list.length; i++) {

        }
        CategoryAdapter adapter = new CategoryAdapter(this, list);
        listView.setAdapter(adapter);*/

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });


        final HashMap<String, MyKey> url_maps = new HashMap<String, MyKey>();
        url_maps.put("Apple MacBook Pro", new MyKey("amazon.com/Apple-MacBook-Retina-2-3GHz-Quad-Core/dp/B07FKCCZSD/ref=sxin_0_osp19-c77cd4f7_cov?ascsubtag=c77cd4f7-6726-4dc1-bb53-6eed62ca82c9&creativeASIN=B07FKCCZSD&crid=1MRPLQRHDB3P5&cv_ct_id=amzn1.osp.c77cd4f7-6726-4dc1-bb53-6eed62ca82c9&cv_ct_pg=search&cv_ct_wn=osp-search&keywords=laptop&linkCode=oas&pd_rd_i=B07FKCCZSD&pd_rd_r=d34d0f3b-973e-4edb-9b66-404798f1e16c&pd_rd_w=VYR8M&pd_rd_wg=bi5Kz&pf_rd_p=37dcfc87-cdc2-4138-941e-56f6d8e6b463&pf_rd_r=43XGREZE9Q7N8XVKZCXB&qid=1553358425&s=electronics&sprefix=laptop%2Celectronics-intl-ship%2C1015&tag=crverifiedexp-20", "https://images-na.ssl-images-amazon.com/images/I/61SJu997CCL._SL1500_.jpg"));
        url_maps.put("Samsung Galaxy S8 Plus", new MyKey("walmart.com/ip/Samsung-Galaxy-S8-Plus-SM-G955U-64GB-T-Mobile-Excellent-Refurbished/628848389", "https://i5.walmartimages.com/asr/269783ed-9c6a-482e-ac46-c836dbf098dd_1.0627de63a3dd71510ff2246e5a14b197.jpeg?odnHeight=450&odnWidth=450&odnBg=FFFFFF"));
        url_maps.put("Redmi Note 7 (Onyx Black, 64 GB)", new MyKey("flipkart.com/redmi-note-7-onyx-black-64-gb/p/itmfdzvfrnfsuywx?pid=MOBFDXZ39EGFJDFJ", "https://rukminim1.flixcart.com/image/832/832/jsnjbm80/mobile/d/f/j/mi-redmi-note-7-mzb7265in-original-imafe6b2v5kn6uny.jpeg?q=70"));
        url_maps.put("প্যারাডক্সিক্যাল সাজিদ ২", new MyKey("rokomari.com/book/178414/paradoxical-sajid-2", "https://s3-ap-southeast-1.amazonaws.com/rokomari110/productNew/260X372/2b532fb15_178414.jpg"));

        System.out.println("url_maps: " + url_maps);
        /*url_maps.put("Big Bang Theory", "https://media.comicbook.com/2017/04/big-bang-theory-cast-kaley-cuoco-jim-parsons-992959.png");
        url_maps.put("House of Cards", "http://cdn3.nflximg.net/images/3093/2043093.jpg");
        url_maps.put("Game of Thrones", "https://ksassets.timeincuk.net/wp/uploads/sites/55/2017/08/2017_GameOfThrones_HBO_220817-920x584.jpg");*/

        for (final String name : url_maps.keySet()) {
            MyKey key = url_maps.get(name);
            TextSliderView textSliderView = new TextSliderView(this);
            // initialize a SliderLayout
            // final String url1 = url_maps.containsKey();
            final String url = key.getUrl();

        /*    final String[] newUrl = url.split("\\/");

            for (String w : newUrl) {
                System.out.println(w);
            }*/
            System.out.println("name : " + name);
            System.out.println("url : " + url);
            textSliderView
                    .description(name)
                    .setScaleType(BaseSliderView.ScaleType.CenterInside)
                    .image(key.getImageUrl())
                    .setOnSliderClickListener(new BaseSliderView.OnSliderClickListener() {
                        @Override
                        public void onSliderClick(BaseSliderView slider) {
                            Toast.makeText(getApplicationContext(), "Image Clicked", Toast.LENGTH_SHORT).show();

                            if (Function.isNetworkAvailable(getApplicationContext())) {

                                Intent intent = new Intent(getApplicationContext(), WebActivity.class);

                                intent.putExtra("address", url);

                                getApplicationContext().startActivity(intent);

                            } else {
                                Toast.makeText(getApplicationContext(), "No Internet Connection", Toast.LENGTH_LONG).show();
                            }
                        }
                    });

            //add your extra information
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra", name);

            mDemoSlider.addSlider(textSliderView);


        }
        mDemoSlider.setPresetTransformer(SliderLayout.Transformer.Accordion);
        mDemoSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        mDemoSlider.setCustomAnimation(new DescriptionAnimation());
        mDemoSlider.setDuration(4000);
        mDemoSlider.addOnPageChangeListener(this);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_mobile) {
            Intent intent = new Intent(getApplicationContext(), ProductActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_laptop) {
            Intent intent = new Intent(getApplicationContext(), ProductActivityLaptop.class);
            startActivity(intent);
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onSliderClick(BaseSliderView slider) {

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
