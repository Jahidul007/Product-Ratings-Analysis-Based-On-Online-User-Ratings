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

        String[] list = {"Mobile", "Laptop", "Camera", "Book", "Sun-glass", "Smartwatch", "Tablet", "Food"};
        List<String> stringList = Arrays.asList(list);
        categoryList = new ArrayList<>();


        for (int i = 0; i < list.length; i++) {


        }
        CategoryAdapter adapter = new CategoryAdapter(this, list);
        listView.setAdapter(adapter);


        final HashMap<String, MyKey> url_maps = new HashMap<String, MyKey>();
        url_maps.put("Hannibal", new MyKey("hypable.com", "http://static2.hypable.com/wp-content/uploads/2013/12/hannibal-season-2-release-date.jpg"));
        url_maps.put("Big Bang Theory", new MyKey("google.com", "https://media.comicbook.com/2017/04/big-bang-theory-cast-kaley-cuoco-jim-parsons-992959.png"));
        url_maps.put("House of Cards", new MyKey("netflix.com","http://cdn3.nflximg.net/images/3093/2043093.jpg"));
        url_maps.put("Game of Thrones", new MyKey("hbo.com/game-of-thrones","https://ksassets.timeincuk.net/wp/uploads/sites/55/2017/08/2017_GameOfThrones_HBO_220817-920x584.jpg"));

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

        if (id == R.id.nav_camera) {
            Intent intent = new Intent(getApplicationContext(), WebActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_gallery) {


        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

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
