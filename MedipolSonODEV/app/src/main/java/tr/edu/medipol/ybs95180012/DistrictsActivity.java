package tr.edu.medipol.ybs95180012;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class DistrictsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_districts);
        String[] districts = {
                "Vali",
                "Çukurca",
                "Derecik",
                "Şemdinli",
                "Yüksekova",
        };

        ListView lvDistricts = findViewById(R.id.lvDistricts);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, districts);
        lvDistricts.setAdapter(adapter);
        lvDistricts.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                View contextView = findViewById(R.id.districtActivityLayout);
                Snackbar.make(contextView, districts[i] + " " + getText(R.string.snackText), Snackbar.LENGTH_SHORT).show();
            }
        });
    }
}