package tr.edu.medipol.ybs95180012;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

public class MyCityActivity extends AppCompatActivity {
    String[] places = {"Isparta", "Firdevs Bey Camii", "Kovada Gölü", "Kuyucak Köyü", "Eğirdir Gölü"};
    ImageView cityImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_city);

        cityImage = findViewById(R.id.ivCity);
        cityImage.setImageResource(R.drawable.isparta);
        Spinner spinner = (Spinner) findViewById(R.id.spinnerCity);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, this.places);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        cityImage.setImageResource(R.drawable.isparta);
                        break;
                    case 1:
                        cityImage.setImageResource(R.drawable.firdevs_bey_camii);
                        break;
                    case 2:
                        cityImage.setImageResource(R.drawable.kovada_golu);
                        break;
                    case 3:
                        cityImage.setImageResource(R.drawable.kuyucak_golu);
                        break;
                    case 4:
                        cityImage.setImageResource(R.drawable.egirdir_golu);
                        break;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }


}