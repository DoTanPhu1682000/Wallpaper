package com.jw.androidday8.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.jw.androidday8.R
import com.jw.androidday8.callback.OnWallpaperItemClickListener
import com.jw.androidday8.databinding.ItemWallpaperBinding
import com.jw.androidday8.model.Wallpaper

class WallpaperAdapter(
    private val wallpapers: List<Wallpaper>,
    private val callback: OnWallpaperItemClickListener
) :
    RecyclerView.Adapter<WallpaperAdapter.ViewHolder>() {
    class ViewHolder( val binding: ItemWallpaperBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(wallpaper: Wallpaper) {
            Glide.with(binding.imgWallpaper)
                .load(wallpaper.wallpaperImage)
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .centerCrop()
                .into(binding.imgWallpaper)
//            binding.imgWallpaper.setImageResource(wallpaper.wallpaperImage)
            binding.tvAuthor.text = wallpaper.author
            binding.tvName.text = wallpaper.wallpaperName
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemWallpaperBinding =
            ItemWallpaperBinding.inflate(LayoutInflater.from(parent.context))
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = wallpapers.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(wallpapers[position])
        holder.binding.imgWallpaper.setOnClickListener {
            callback.onClick(position)
        }
    }

}