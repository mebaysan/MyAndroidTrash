package tr.edu.medipol.myapplication;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText etName = findViewById(R.id.etName);
        EditText etSurname = findViewById(R.id.etSurname);
        EditText etDepartment = findViewById(R.id.etDepartment);

        Button btnSave = findViewById(R.id.btnSave);
        btnSave.setVisibility(View.VISIBLE);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, R.string.success, Toast.LENGTH_SHORT).show();

                Intent data = new Intent();
                data.putExtra("name", etName.getText().toString() );
                data.putExtra("surname", etSurname.getText().toString());
                data.putExtra("department", etDepartment.getText().toString());

                setResult(RESULT_OK, data);
                finish();

            }
        });
        Log.d("ceviri: ", getString(R.string.success));

        setTitle(R.string.student_form);


    }

}