package com.baysansoft.medipoltodolist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AddToDoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_to_do);
        setTitle(R.string.todoForm);
    }

    public void addToDo(View view) {
        EditText tvToDoName = findViewById(R.id.tvToDoName); // TextView item'ı yakalıyoruz
//        System.out.println(String.format("ToDo Name -> %s", tvToDoName.getText().toString()));
        if (TextUtils.isEmpty(tvToDoName.getText().toString())) { // EditText'in value'si boş mu?

            Toast.makeText(this, R.string.addToDoError, Toast.LENGTH_LONG).show(); // boş ise uyar

        } else { // değilse data içerisine göm ve bu activity'i sonlandır, önceki parent activity'e data'yı dön

            Intent data = new Intent(); // Intent tipinde bir data nesnesi oluşturuyoruz
            data.putExtra("todoName", tvToDoName.getText().toString()); // todoName key'inde tvToDoName'in değerini value olarak set ediyoruz
            setResult(RESULT_OK, data); // bu activity'i sonlandırmadan önce RESULT_OK olarak işaretliyoruz ve data objesini set ediyoruz
            finish(); // activity'i sonlandırıyoruz
        }

    }

}