package com.jw.androidday8

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.jw.androidday8.adapter.WallpaperAdapter
import com.jw.androidday8.callback.OnWallpaperItemClickListener
import com.jw.androidday8.databinding.ActivityMainBinding
import com.jw.androidday8.model.Wallpaper

class MainActivity : AppCompatActivity(), OnWallpaperItemClickListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: WallpaperAdapter
    private val wallpapers = listOf(
        Wallpaper(R.drawable.january, "January", "Phu"),
        Wallpaper(R.drawable.february, "february", "Phu"),
        Wallpaper(R.drawable.march, "march", "Phu"),
        Wallpaper(R.drawable.april, "april", "Phu"),
        Wallpaper(R.drawable.may, "may", "Phu"),
        Wallpaper(R.drawable.june, "june", "Phu"),
        Wallpaper(R.drawable.july, "july", "Phu"),
        Wallpaper(R.drawable.september, "september", "Phu"),
        Wallpaper(R.drawable.august, "august", "Phu"),
        Wallpaper(R.drawable.october, "october", "Phu"),
        Wallpaper(R.drawable.november, "november", "Phu"),
        Wallpaper(R.drawable.december, "december", "Phu")
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = WallpaperAdapter(wallpapers, this)
        binding.rwWallpaper.layoutManager =
            GridLayoutManager(this, 2)
        binding.rwWallpaper.adapter = adapter
    }

    override fun onClick(position: Int) {
        val wallpaperIntent = Intent(this, DetailWallpaperActivity::class.java)
        val wallpaper = wallpapers[position]
        val bundle = Bundle()
        bundle.putSerializable("wallpaper", wallpaper)
        wallpaperIntent.putExtras(bundle)


        val app: WallpaperApplication = application as WallpaperApplication
        app.wallpaperImage = wallpaper.wallpaperImage
        app.wallpaperAuthor = wallpaper.author
        app.wallpaperName = wallpaper.wallpaperName

        startActivity(wallpaperIntent)
    }
}