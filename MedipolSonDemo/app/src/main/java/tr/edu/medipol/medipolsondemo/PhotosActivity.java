package tr.edu.medipol.medipolsondemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;

public class PhotosActivity extends AppCompatActivity {
    String[] photos = {
            "https://images.pexels.com/photos/1092644/pexels-photo-1092644.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            "https://images.pexels.com/photos/54284/pexels-photo-54284.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            "https://images.pexels.com/photos/2228569/pexels-photo-2228569.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            "https://images.pexels.com/photos/887751/pexels-photo-887751.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            "https://images.pexels.com/photos/1181244/pexels-photo-1181244.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500"


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
                    Intent intent = new Intent(PhotosActivity.this, PhotoDetailActivity.class);
                    intent.putExtra("photo", photoURL);
                    startActivity(intent);
                }
            });
            llPhotos.addView(ivPhoto);
        }
    }
}