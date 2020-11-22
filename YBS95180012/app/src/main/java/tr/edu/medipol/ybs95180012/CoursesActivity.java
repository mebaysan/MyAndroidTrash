package tr.edu.medipol.ybs95180012;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class CoursesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courses);
        ListView lvList = findViewById(R.id.lvLessons);

        String[] lessons = {"Mobil Programlama", "İş ve Sosyal Güvenlik Hukuku", "İşletmelerde Nicel Karar Verme Yöntemleri", "Sistem Analizi ve Tasarımı", "Lojistik Yönetimi", "Pazarlamanın İlkeleri", "Veri Tabanı Yönetim Sistemleri"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lessons);

        lvList.setAdapter(adapter);
        lvList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(CoursesActivity.this, lessons[i], Toast.LENGTH_SHORT).show();
            }
        });
    }
}