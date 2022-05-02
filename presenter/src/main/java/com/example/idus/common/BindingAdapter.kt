package com.example.idus.common

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.example.idus.R

object BindingAdapter {

    @JvmStatic
    @BindingAdapter("imageLoad")
    fun loadImage(imageView: ImageView, str: String?) {
        Glide.with(imageView.context)
            .load(String.format(imageView.context.resources.getString(R.string.image_url), str))
            .into(imageView)
    }

}