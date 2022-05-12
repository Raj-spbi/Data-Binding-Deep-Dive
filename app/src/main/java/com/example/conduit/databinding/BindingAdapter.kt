package com.example.conduit.databinding

import android.content.Context
import android.text.TextWatcher
import android.widget.EditText
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.google.android.material.textfield.TextInputLayout

@BindingAdapter("app:textwatcher")
fun watcher(view: EditText, textWatcher: TextWatcher) {
    view.addTextChangedListener(textWatcher)
}

@BindingAdapter("app:error")
fun error(view: TextInputLayout, errorString: String?) {

    view.isErrorEnabled = true
    view.error = errorString
}

@BindingAdapter(value = ["app:imageUrl", "app:context"], requireAll = true)
fun loadImage(view: ImageView, url: String?, context: Context) {
    Glide.with(context).load(url).into(view)
}