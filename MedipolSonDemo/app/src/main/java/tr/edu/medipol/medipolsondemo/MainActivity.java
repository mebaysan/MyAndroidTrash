package tr.edu.medipol.medipolsondemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnPhotos = findViewById(R.id.btnPhotos);
        btnPhotos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, PhotosActivity.class));
            }
        });
    }

    public void startWeatherActivity(View view) {
        startActivity(new Intent(this, WeatherActivity.class));
    }
}