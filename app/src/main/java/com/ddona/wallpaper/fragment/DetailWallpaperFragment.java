package com.ddona.wallpaper.fragment;

import android.app.WallpaperManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.ddona.wallpaper.R;
import com.ddona.wallpaper.model.Wallpaper;

import java.io.IOException;

public class DetailWallpaperFragment extends Fragment {

    private Wallpaper wallpaper;

    public DetailWallpaperFragment() {
    }

    public DetailWallpaperFragment(Wallpaper wallpaper) {
        this.wallpaper = wallpaper;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_wallpaper_detail,
                container, false);
        TextView tvName = view.findViewById(R.id.tv_image_name);
        TextView tvAuthor = view.findViewById(R.id.tv_image_author);

        ImageView imgWallpaper = view.findViewById(R.id.img_wallpaper);
        tvAuthor.setText(wallpaper.getAuthor());
        tvName.setText(wallpaper.getName());
        Glide.with(view)
                .load(wallpaper.getImageId())
                .placeholder(R.mipmap.ic_launcher)
                .into(imgWallpaper);
        view.findViewById(R.id.btn_set_as_wallpaper)
                .setOnClickListener(v -> {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                WallpaperManager.getInstance(getContext())
                                        .setResource(wallpaper.getImageId());
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }).start();
                });
        return view;
    }
}
