package com.baysansoft.intro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); // önce miras aldığım sınıfın metodu çalışsın
        setContentView(R.layout.activity_main);


    }

    public void getInfo(View view) {
        startActivity(
                new Intent(this, Info.class) // Intent oluşturuyoruz
        ); // yeni bir aktivite başlatıyoruz
    }

    public void getLogin(View view) {
        EditText etUsername = findViewById(R.id.etUsername); // etUsername component'ini yakalıyoruz
        EditText etPassword = findViewById(R.id.etPassword);
        String username = etUsername.getText().toString(); // component'e yazılan stringi değişkene atıyoruz
        String password = etPassword.getText().toString();

        Log.d("username", username); // logcat'e log basıyoruz
        Log.d("password", password);

        if (username.equals("baysan") && password.equals("123")) { // Java'da string karşılaştırma equals() ile yapılır
            Toast.makeText(this, "Giriş Yapılabilir :)", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Kullanıcı Bilgileri Yanlış!", Toast.LENGTH_LONG).show(); // toast mesaj oluşturuyoruz. this -> bu activity, text -> toast metni, 3. parametre ise toast süre uzunluğu
        }
    }
}