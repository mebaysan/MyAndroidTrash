package com.baysansoft.medipoltodolist;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.TypedArrayUtils;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Arrays;
/*
    @mebaysan
    05/11/2020 16:20
    github.com/mebaysan
    ^^
 */
public class MainActivity extends AppCompatActivity {
    public String[] ToDos = {}; // ToDo'lar için bir liste oluşturuyoruz

    void setToDoList(@Nullable String toDo) { // MainActivity sınıfının ToDos listesine eleman ekliyoruz
        if (toDo != null) {
            this.ToDos = Arrays.copyOf(ToDos, ToDos.length + 1); // ToDos listesini kendisinin kopyası ile değiştiriyoruz fakat eleman uzunluğu 1 artıyor
            this.ToDos[this.ToDos.length - 1] = toDo; // artırılmış toplam uzunluğu 2 varsayalım; 2 - 1 = 1. index (yani 2. sıradaki eleman) 'e gelen toDo stringini ekliyoruz
        }
    }

    ArrayAdapter<String> getToDoAdapter(@Nullable String[] ToDoList) {
        ArrayAdapter<String> adapterToDos; // ListView için bir adapter hazırlıyoruz
        if (ToDoList != null) { // eğer gelen bir liste varsa gelen listeyi adapter ile bind ediyoruz
            adapterToDos = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, ToDoList);
        } else {
            adapterToDos = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, this.ToDos);
        }
        return adapterToDos;
    }

    void checkVisibility() {
        /*
                Android Visibility Özellikleri
               VISIBLE   -> item gözükür
               INVISIBLE -> item gözükmez ama yeri tutulur
               GONE      -> item gözükmez ve yeri de tutulmaz
        */

        ListView lvToDos = findViewById(R.id.lvToDoList); // ListView component'i buluyoruz
        TextView tvInfo = findViewById(R.id.tvInfo);
        if (this.ToDos.length == 0) { // eğer ToDos listesinin eleman sayısı 0 ise ListView gizlenecek ve Info Texti gözükecek
            lvToDos.setVisibility(View.INVISIBLE);
            tvInfo.setVisibility(View.VISIBLE);
        } else { // eğer ToDos listesinde eleman varsa ListView gözükecek
            lvToDos.setVisibility(View.VISIBLE);
            tvInfo.setVisibility(View.GONE);
        }
    }

    void checkAdapterState() { // adapter durumunu kontrol ediyoruz, boş yere listview'a bind etmeyelim diye
        ListView lvToDos = findViewById(R.id.lvToDoList); // ListView component'i buluyoruz
        if (this.ToDos.length > 0) {
            lvToDos.setAdapter(this.getToDoAdapter(this.ToDos)); // ListView'a adapter'i set ediyoruz
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkAdapterState(); // adapter durumunu kontrol ediyoruz. Eğer ToDos listesi elemanları > 0 ise component'e adapter'i set ediyoruz
        checkVisibility(); // ToDos eleman sayısına göre component'lerin görünürlüğünü kontrol ediyoruz
    }

    public void navToAddNewItem(View view) { // Anasayfada todo ekle butonuna tıklanınca çalışacak fonksiyon
        startActivityForResult(new Intent(MainActivity.this, AddToDoActivity.class), 1); // AddToDoActivity activity'e yönlendiriyoruz ve bir istek code set ediyoruz. Bu sayede orada işlenen datayı alabileceğiz.
        // startActivityForResult hedef activity için bir intent oluşturuyoruz ve orada yapılan işlemlerden dönen verilere ulaşabiliyoruz
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) { // bu activity'e bir sonuç (result) döndüğünde bu fonksiyon(metod) çalışacak
        super.onActivityResult(requestCode, resultCode, data); // requestCode -> hedef activity'e yolladığımız istek kodu, resultCode -> hedef activty'den bize dönen durum kodu, data -> hedef activity'de set edilen Intent data
        if (requestCode == 1) { // eğer istek kodu 1 ise (yukarıda istek atarken biz set etmiştik)
            if (resultCode == RESULT_OK) {
                ListView lvToDos = findViewById(R.id.lvToDoList); // ListView component'i buluyoruz
                TextView tvInfo = findViewById(R.id.tvInfo); // textview componenti buluyoruz ki value'sine erişip ToDos listesine ekleyeceğiz
                setToDoList(data.getStringExtra("todoName")); // MainActivity sınıfının ToDos listesine eleman ekliyoruz
                checkAdapterState();
                checkVisibility();
            }
        }
    }

}