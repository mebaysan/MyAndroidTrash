package tr.edu.medipol.medipolsondemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class WeatherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        ImageView ivWeather = findViewById(R.id.ivWeather);
        Glide.with(this).load("https://www.mgm.gov.tr/sunum/tahmin-show-2.aspx?m=ISTANBUL&basla=1&bitir=5&rC=111&rZ=fff").into(ivWeather);

        TextView tvMGM = findViewById(R.id.tvMGM);
        tvMGM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.mgm.gov.tr/?il=Istanbul")));
            }
        });
    }
}