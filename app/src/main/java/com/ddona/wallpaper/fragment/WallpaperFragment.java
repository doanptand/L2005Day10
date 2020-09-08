package com.ddona.wallpaper.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ddona.wallpaper.R;
import com.ddona.wallpaper.adapter.WallpaperAdapter;
import com.ddona.wallpaper.model.Wallpaper;

import java.util.ArrayList;
import java.util.List;

public class WallpaperFragment extends Fragment {
    private RecyclerView rvWallpaper;
    private List<Wallpaper> wallpapers;
    private WallpaperAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater
                .inflate(R.layout.fragment_wallpaper, container, false);
        wallpapers = new ArrayList<>();
        wallpapers.add(new Wallpaper(R.drawable.january, "January", "Trung Doan"));
        wallpapers.add(new Wallpaper(R.drawable.february, "January", "Trung Doan"));
        wallpapers.add(new Wallpaper(R.drawable.march, "January", "Trung Doan"));
        wallpapers.add(new Wallpaper(R.drawable.april, "January", "Trung Doan"));
        wallpapers.add(new Wallpaper(R.drawable.may, "January", "Trung Doan"));
        wallpapers.add(new Wallpaper(R.drawable.june, "January", "Trung Doan"));
        wallpapers.add(new Wallpaper(R.drawable.july, "January", "Trung Doan"));
        wallpapers.add(new Wallpaper(R.drawable.august, "January", "Trung Doan"));
        wallpapers.add(new Wallpaper(R.drawable.september, "January", "Trung Doan"));
        wallpapers.add(new Wallpaper(R.drawable.october, "January", "Trung Doan"));
        wallpapers.add(new Wallpaper(R.drawable.november, "January", "Trung Doan"));
        wallpapers.add(new Wallpaper(R.drawable.december, "January", "Trung Doan"));

        adapter = new WallpaperAdapter(wallpapers, getContext());

        rvWallpaper = view.findViewById(R.id.rc_wallpaper);
        GridLayoutManager layoutManager =
                new GridLayoutManager(getContext(), 2);
        rvWallpaper.setLayoutManager(layoutManager);
        rvWallpaper.setAdapter(adapter);

        return view;
    }
}
