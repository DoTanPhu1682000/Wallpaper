package com.jw.androidday8

import android.app.WallpaperManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar
import com.jw.androidday8.databinding.ActivityDetailWallpaperBinding
import com.jw.androidday8.model.Wallpaper

class DetailWallpaperActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailWallpaperBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailWallpaperBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val wallpaper = intent.getSerializableExtra("wallpaper") as Wallpaper
        Glide.with(this)
            .load(wallpaper.wallpaperImage)
            .placeholder(R.mipmap.ic_launcher)
            .centerCrop()
            .into(binding.imgWallpaper)
        binding.tvAuthor.text = wallpaper.author
        binding.tvName.text = wallpaper.wallpaperName

        val app: WallpaperApplication = application as WallpaperApplication
        Log.d("Phu", app.wallpaperName + " " + app.wallpaperAuthor + "" + app.wallpaperImage)

        binding.btnSetWallPaper.setOnClickListener {
            Thread {
                WallpaperManager.getInstance(this).setResource(wallpaper.wallpaperImage)
            }.start()
            Snackbar.make(binding.imgWallpaper, "Sucess", Snackbar.LENGTH_SHORT).show()
        }

    }
}