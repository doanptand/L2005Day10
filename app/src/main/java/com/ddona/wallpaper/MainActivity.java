package com.ddona.wallpaper;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.ddona.wallpaper.fragment.DetailWallpaperFragment;
import com.ddona.wallpaper.fragment.WallpaperFragment;
import com.ddona.wallpaper.model.Wallpaper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.fl_content, new WallpaperFragment());
        transaction.commit();
    }

    public void showDetailWallpaper(Wallpaper wallpaper) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fl_content,
                new DetailWallpaperFragment(wallpaper));
        transaction.commit();
    }
}