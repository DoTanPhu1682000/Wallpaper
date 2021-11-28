package com.jw.androidday8.extension

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide


fun ImageView.loadImageFromLink(url: String) {
    Glide.with(this).load(url).into(this)
}
@BindingAdapter("res_string")
fun loadImageFromUrl(view: ImageView, url: String) {
    Glide.with(view).load(url).into(view)
}