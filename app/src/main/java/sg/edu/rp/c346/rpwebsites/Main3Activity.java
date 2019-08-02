package sg.edu.rp.c346.rpwebsites;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Main3Activity extends AppCompatActivity {
    WebView wvRP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        wvRP = findViewById(R.id.WebViewRP);
        wvRP.setWebViewClient(new WebViewClient());

        Intent intentReceived = getIntent();
        String url = intentReceived.getStringExtra("url");
        wvRP.loadUrl(url);

        WebSettings webSettings = wvRP.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.getAllowFileAccess();
        webSettings.getBuiltInZoomControls();
    }
}
