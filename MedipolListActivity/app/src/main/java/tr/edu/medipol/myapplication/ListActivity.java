package tr.edu.medipol.myapplication;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class ListActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ListView lvList = findViewById(R.id.lvList);

        String[] students = {"Mustafa ÖZCAN", "Okan COŞAR", "Yunus Emre YILMAZ", "Mehmet CAN", "Uğur Baran OSANMAZ", "Mert IŞIK", "Melike YILDIRIM", "Alkım ÖZCAN", "Murat MERT", "Oğuzhan YAVUZ", "Soner KESKİN", "Bora CİRİT", "Enes BAYSAN"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, students);

        lvList.setAdapter(adapter);

        lvList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(ListActivity.this,  students[i]  , Toast.LENGTH_SHORT).show();
            }
        });


        Button btnNew = findViewById(R.id.btnNew);
        btnNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivityForResult(new Intent(ListActivity.this, MainActivity.class), 1);

            }
        });





    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 1){
            if(resultCode == RESULT_OK){
                Log.e("onActivityResult: ", "ok");
                Log.e( "name: ", data.getStringExtra("name") );
                Log.e( "surname: ", data.getStringExtra("surname") );
                Log.e( "department: ", data.getStringExtra("department") );
                //data.getStringExtra("name");
                //data.getStringExtra("surname");
                //data.getStringExtra("department");

            }

        }

    }
}