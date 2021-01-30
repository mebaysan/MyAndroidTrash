package tr.edu.medipol.ybs95180012;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class WebViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        String dataURL = getIntent().getStringExtra("dataURL");
        WebView wvWeb = findViewById(R.id.wvWeb);
        wvWeb.loadUrl(dataURL);

    }
}