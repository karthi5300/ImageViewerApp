package com.karthick.imageviewerapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.palette.graphics.Palette;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class ImageActivity extends AppCompatActivity {

    ImageView mImageView;
    RelativeLayout relativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        //SET TITLE
        setTitle("Image Details");

        mImageView = findViewById(R.id.activity_image_view);
        relativeLayout = findViewById(R.id.relative_layout);

        Intent receivedIntent = getIntent();
        final String url = receivedIntent.getStringExtra("image_id");

        Picasso.get().load(url).into(mImageView);
        Bitmap bitmap = ((BitmapDrawable) mImageView.getDrawable()).getBitmap();
        setBackgroundColor(bitmap);
    }

    public void setBackgroundColor(Bitmap bitmap) {
        Palette.from(bitmap).maximumColorCount(32).generate(new Palette.PaletteAsyncListener() {
            @Override
            public void onGenerated(Palette palette) {
                //GET VIBRANT SWATCH
                Palette.Swatch vibrantSwatch = palette.getVibrantSwatch();

                //SET BACKGROUND COLOR
                if (vibrantSwatch != null) {
                    relativeLayout.setBackgroundColor(vibrantSwatch.getRgb());
                }
            }
        });
    }
}
