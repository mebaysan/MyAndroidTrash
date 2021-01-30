package tr.edu.medipol.ybs95180012;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle(R.string.cityName);
        TextView tvCityWeather = findViewById(R.id.tvCityWeather);
        tvCityWeather.setText(getString(R.string.cityName) + " " + getText(R.string.cityWeather));
        ImageView ivCityWeather = findViewById(R.id.ivCityWeather);
        String cityName = "HAKKARI";
        String weatherURL = "https://www.mgm.gov.tr/sunum/tahmin-show-2.aspx?m=" + cityName + "&basla=1&bitir=5&rC=111&rZ=fff";
        Glide.with(this).load(weatherURL).into(ivCityWeather);
        Button btnWebView = findViewById(R.id.btnWebView);
        btnWebView.setText(getText(R.string.btnAboutText) + " " + getText(R.string.cityName));

    }

    public void getWebViewIntent(View view) {
        String valiURL = "http://www.hakkari.gov.tr/"; // farklı bir url'i deneyince oluyor hocam fakar hakkari valiliğine ait web sitesini açmıyor
        Intent intent = new Intent(this, WebViewActivity.class);
        intent.putExtra("dataURL", valiURL);
        startActivity(intent);
    }

    public void getDistrictsActivity(View view) {
        startActivity(new Intent(this, DistrictsActivity.class));
    }

    public void getPhotosActivity(View view) {
        startActivity(new Intent(this, PhotosActivity.class));
    }
}