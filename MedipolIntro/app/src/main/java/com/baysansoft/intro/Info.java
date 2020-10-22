package com.baysansoft.intro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Info extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
    }

    public void callPhone(View view) {
        // intent filter eklenmesine rağmen çalışmadı
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + "+905308626253"));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Toast.makeText(this, "Uygun Çeviri Programı Bulunamadı", Toast.LENGTH_LONG).show();
        }
    }

    public void toEmail(View view) {
        // intent filter eklenince çalıştı
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // bu Intent'i yalnızca mail programları yakalayabilir!
        intent.putExtra(Intent.EXTRA_EMAIL, "info@baysansoft.com");
        intent.putExtra(Intent.EXTRA_SUBJECT, "BaysanSoft Müşteri Talebi");
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Toast.makeText(this, "Uygun Mail Programı Bulunamadı", Toast.LENGTH_LONG).show();

        }
    }

    public void toWeb(View view) {
        // intent filter eklenmesine rağmen çalışmadı
        Uri webpage = Uri.parse("https://www.baysansoft.com/#contact");
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Toast.makeText(this, "Uygun Web Programı Bulunamadı", Toast.LENGTH_LONG).show();
        }
    }
}