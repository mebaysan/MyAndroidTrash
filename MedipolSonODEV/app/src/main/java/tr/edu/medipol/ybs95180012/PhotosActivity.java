package tr.edu.medipol.ybs95180012;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;

public class PhotosActivity extends AppCompatActivity {
    String[] photos = {
            "https://i12.haber7.net//haber/haber7/photos/2017/36/hakkari_icin_kritik_karar_3_ilcede_15_gun_1504859805_6407.jpg",
            "https://i.pinimg.com/originals/4c/d4/81/4cd481146d6d17ec3a97dc67ea512189.jpg",
            "https://i4.hurimg.com/i/hurriyet/75/590x332/5c8d55eaeb10bb2384ce8db1.jpg",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQq3ItwIW_0Hy6RckjNzHYX9AXj6mMILhDB3g&usqp=CAU",
            "https://i4.hurimg.com/i/hurriyet/75/590x332/5bc04d92eb10bb2e585cb36e.jpg"


    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photos);
        LinearLayout llPhotos = findViewById(R.id.llPhotos);
        for (int i = 0; i < photos.length; i++) {
            ImageView ivPhoto = new ImageView(this);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            ivPhoto.setLayoutParams(params);
            if (i == 0) {
                ivPhoto.setPadding(0, 0, 0, 10);
            } else if (i == photos.length - 1) {
                ivPhoto.setPadding(0, 10, 0, 0);
            } else {
                ivPhoto.setPadding(0, 10, 0, 10);
            }
            Glide.with(this).load(photos[i]).into(ivPhoto);
            ivPhoto.setClickable(true);
            String photoURL = photos[i];
            ivPhoto.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(PhotosActivity.this, WebViewActivity.class);
                    intent.putExtra("dataURL", photoURL);
                    startActivity(intent);
                }
            });
            llPhotos.addView(ivPhoto);
        }
    }
}