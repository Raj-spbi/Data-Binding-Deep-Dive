package com.example.conduit.databinding

import android.content.Context
import android.text.TextWatcher
import android.widget.EditText
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.conduit.databinding.recycler.AdapterRecycler
import com.example.conduit.databinding.viewmodel.MainViewModel
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

/*@BindingAdapter("app:setAdapter")
fun setAdapter(view: RecyclerView,viewModel: MainViewModel) {
    view.adapter=viewModel.setAdapter()


}*/
//@BindingAdapter("app:onclick")
//fun onClick(view: View) {
////    view.addTextChangedListener(textWatcher)
//}
