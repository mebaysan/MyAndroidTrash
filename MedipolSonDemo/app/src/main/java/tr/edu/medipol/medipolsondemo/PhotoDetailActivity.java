package tr.edu.medipol.medipolsondemo;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.WallpaperManager;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.davemorrissey.labs.subscaleview.ImageSource;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;

import java.io.IOException;

public class PhotoDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_detail);
        String photoURL = getIntent().getStringExtra("photo");
        SubsamplingScaleImageView imageView = findViewById(R.id.ivSubsamplingScaleImageView);
        Button btnWallpaper = findViewById(R.id.btnWallpaper);

        Glide.with(this).asBitmap().load(photoURL).into(new SimpleTarget<Bitmap>(800, 1200) {
            @Override
            public void onResourceReady(@NonNull Bitmap resource, @Nullable Transition<? super Bitmap> transition) {
                imageView.setImage(ImageSource.bitmap(resource));
                btnWallpaper.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        try {
                            new AlertDialog.Builder(PhotoDetailActivity.this).setTitle(R.string.photoDetailWarning)
                                    .setMessage(R.string.photoDetailMessage)
                                    .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            dialog.dismiss();
                                        }
                                    }).setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    try {
                                        WallpaperManager.getInstance(PhotoDetailActivity.this).setBitmap(resource);
                                        Toast.makeText(PhotoDetailActivity.this, "Background changed successfully!", Toast.LENGTH_LONG).show();
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                    // message
                                    dialog.dismiss();
                                }
                            }).show();

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });


    }
}