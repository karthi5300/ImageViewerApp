package com.karthick.imageviewerapp;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.palette.graphics.Palette;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

public class ImageAdapter extends RecyclerView.Adapter {

    private String[] mImageUrl;
    private Context mContext;

    public ImageAdapter(String[] imageUrl, Context context) {
        mImageUrl = imageUrl;
        mContext = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_item, parent, false);

        ImageViewHolder imageViewHolder = new ImageViewHolder(view);
        return imageViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((ImageViewHolder) holder).bindView(position);
    }

    @Override
    public int getItemCount() {
        return mImageUrl.length;
    }

    //VIEWHOLDER CLASS
    class ImageViewHolder extends RecyclerView.ViewHolder {

        private ImageView mImageView;
        private CardView mCardView;

        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);

            mImageView = itemView.findViewById(R.id.image_view);
            mCardView = itemView.findViewById(R.id.card_view);
        }

        public void bindView(final int position) {
            String url = mImageUrl[position];

            Picasso.get().load(url).into(mImageView);

            mCardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mContext, ImageActivity.class);
                    intent.putExtra("image_id", mImageUrl[position]);
                    mContext.startActivity(intent);
                }
            });
        }
    }
}
