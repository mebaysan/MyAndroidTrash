package tr.edu.medipol.ybs95180012;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void callMe(View view) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + "+905308626253"));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Toast.makeText(this, R.string.callWarningText, Toast.LENGTH_LONG).show();
        }
    }

    public void mailMe(View view) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_EMAIL, "muhammed.baysan@std.medipol.edu.tr");
        intent.putExtra(Intent.EXTRA_SUBJECT, "Mobil Programlama Vize Ödevi");
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Toast.makeText(this, R.string.btnMailWarning, Toast.LENGTH_LONG).show();

        }
    }

    public void openCoursesActivity(View view) {
        startActivity(
                new Intent(this, CoursesActivity.class)
        );
    }

    public void openCityActivity(View view) {
        startActivity(
                new Intent(this, MyCityActivity.class)
        );
    }
}