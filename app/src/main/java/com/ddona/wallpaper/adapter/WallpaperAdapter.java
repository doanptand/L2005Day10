package com.ddona.wallpaper.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.ddona.wallpaper.R;
import com.ddona.wallpaper.callback.OnWallpaperItemClickListener;
import com.ddona.wallpaper.model.Wallpaper;

import java.util.List;

public class WallpaperAdapter extends RecyclerView.Adapter<WallpaperAdapter.ViewHolder> {
    private List<Wallpaper> wallpapers;
    private Context mContext;
    private OnWallpaperItemClickListener callback;

    public WallpaperAdapter(List<Wallpaper> wallpapers, Context mContext, OnWallpaperItemClickListener callback) {
        this.wallpapers = wallpapers;
        this.mContext = mContext;
        this.callback = callback;
    }

    @NonNull
    @Override
    public WallpaperAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_wallpaper,
                        parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WallpaperAdapter.ViewHolder holder, final int position) {
        Wallpaper wallpaper = wallpapers.get(position);
        holder.tvAuthor.setText(wallpaper.getAuthor());
        holder.tvName.setText(wallpaper.getName());
        Glide.with(mContext)
                .load(wallpaper.getImageId())
                .placeholder(R.mipmap.ic_launcher)
                .into(holder.imgId);
//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                callback.onWallpaperClick(position);
//            }
//        });

        holder.itemView.setOnClickListener(view ->
                callback.onWallpaperClick(position)
        );
    }

    @Override
    public int getItemCount() {
        return wallpapers.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgId;
        TextView tvName;
        TextView tvAuthor;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgId = itemView.findViewById(R.id.img_wallpaper);
            tvName = itemView.findViewById(R.id.tv_image_name);
            tvAuthor = itemView.findViewById(R.id.tv_image_author);
        }
    }
}
