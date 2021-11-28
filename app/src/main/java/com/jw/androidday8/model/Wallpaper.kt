package com.jw.androidday8.model

import java.io.Serializable

data class Wallpaper(
    val wallpaperImage: Int,
    var wallpaperName: String,
    val author: String = "Phu"
): Serializable