package com.jahid.productratings;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class WebActivity extends AppCompatActivity {

    WebView webView;
    private ProgressBar spinner;
    Button button1;
    TextView textView1;
    private Bundle extras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.web_view);

        try {
            webView = findViewById(R.id.webView1);
            WebSettings webSetting = webView.getSettings();
            webSetting.setJavaScriptEnabled(true);
            webSetting.setDisplayZoomControls(true);

            webView.getSettings().setJavaScriptEnabled(true);
            webView.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
            webView.getSettings().setDomStorageEnabled(true);

            textView1 = (TextView) findViewById(R.id.view_pager);
            button1 = findViewById(R.id.button);
            spinner = (ProgressBar) findViewById(R.id.progressBar1);

            ConnectivityManager ConnectionManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = ConnectionManager.getActiveNetworkInfo();
            if (networkInfo != null && networkInfo.isConnected() == true) {
                textView1.setVisibility(View.INVISIBLE);
                button1.setVisibility(View.INVISIBLE);
                webView.setWebViewClient(new MyWebViewClient());
                extras = getIntent().getExtras();
                //String url = "http://tutorsbangladesh.com/";
                String url =extras.getString("address");
                webView.loadUrl(url);
            } else {
                textView1.setVisibility(View.VISIBLE);
                spinner.setVisibility(View.INVISIBLE);
                button1.setText("Refresh");
                button1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ConnectivityManager ConnectionManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
                        final NetworkInfo networkInfo2 = ConnectionManager.getActiveNetworkInfo();
                        if (networkInfo2 != null && networkInfo2.isConnected() == true) {
                            textView1.setVisibility(View.INVISIBLE);
                            button1.setVisibility(View.INVISIBLE);
                            webView.setWebViewClient(new MyWebViewClient());
                            String url = "https://www.google.com/";
                            webView.loadUrl(url);
                        }
                    }
                });
            }


        } catch (Exception ex) {
            Toast toast = Toast.makeText(getApplicationContext(), ex.toString(), Toast.LENGTH_SHORT);
            toast.show();
        }
    }


    private class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }

        @Override
        public void onPageStarted(WebView webview, String url, Bitmap favicon) {
            spinner.setVisibility(View.VISIBLE);
            webview.setVisibility(webview.INVISIBLE);
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            spinner.setVisibility(View.GONE);
            view.setVisibility(webView.VISIBLE);
            super.onPageFinished(view, url);
        }

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && webView.canGoBack()) {
            webView.goBack();
            return true;
        } else {
            finish();
            return true;
        }
    }
}
