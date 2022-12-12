package br.com.lucaopoletis.marveapp.util

import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide

fun Fragment.toast(message: String, duration: Int = Toast.LENGTH_LONG) {
    Toast.makeText(
        requireContext(),
        message,
        duration
    ).show()
}

fun View.show() {
    visibility = View.VISIBLE
}

fun View.hide() {
    visibility = View.INVISIBLE
}

fun loadImage(
    imageView: ImageView,
    path: String,
    extension: String
) {
    Glide.with(imageView.context)
        .load("$path.$extension")
        .into(imageView)
}

fun String.limitDescription(character: Int): String {
    if (this.length > character) {
        val firstCharacter = 0
        return "${this.substring(firstCharacter, character)}..."
    }
    return this
}