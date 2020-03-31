package com.karthick.imageviewerapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private final String[] imageUrl = {
            "https://image.tmdb.org/t/p/w780/xfWac8MTYDxujaxgPVcRD9yZaul.jpg",
            "https://image.tmdb.org/t/p/w780/4Iu5f2nv7huqvuYkmZvSPOtbFjs.jpg",
            "https://image.tmdb.org/t/p/w780/wFFlaVHmQG4U43m0l3eQqHZluvn.jpg",
            "https://image.tmdb.org/t/p/w780/4ynQYtSEuU5hyipcGkfD6ncwtwz.jpg",
            "https://image.tmdb.org/t/p/w780/6I2tPx6KIiBB4TWFiWwNUzrbxUn.jpg",
            "https://image.tmdb.org/t/p/w780/zBK4QZONMQXhcgaJv1YYTdCW7q9.jpg",
            "https://image.tmdb.org/t/p/w780/oFOG2yIRcluKfTtYbzz71Vj9bgz.jpg",
            "https://image.tmdb.org/t/p/w780/anmLLbDx9d98NMZRyVUtxwJR6ab.jpg",
            "https://image.tmdb.org/t/p/w780/i9flZtw3BwukADQpu5PlrkwPYSY.jpg"
    };

    private Context mContext = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView mRecyclerView;
        RecyclerView.Adapter mAdapter;

        mRecyclerView = findViewById(R.id.recycler_view);

        RecyclerView.LayoutManager gridLayoutManager = new GridLayoutManager(this, 2);

        mRecyclerView.setLayoutManager(gridLayoutManager);
        mRecyclerView.setHasFixedSize(true);

        mAdapter = new ImageAdapter(imageUrl, mContext);
        mRecyclerView.setAdapter(mAdapter);

    }


}
