package com.example.conduit.databinding

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.conduit.R
import com.example.conduit.databinding.viewmodel.TestViewModel

class Activity1 : AppCompatActivity() {

    lateinit var binding: Activity1Binding
    lateinit var viewModel: TestViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_1)
        viewModel = ViewModelProvider(this).get(TestViewModel::class.java)

        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        binding.mContext = this

        viewModel.textData.value = "Test Data First"
        viewModel.btnText.value = "Click to Do"
        viewModel.imageUrl.value =
            "https://avatars.githubusercontent.com/u/55589404?s=400&u=9f56f35abf3e1112d40d2384a5f1e871e9ef70c6&v=4"

        viewModel.etTextInputLayout.observe(this) {
            if (viewModel.isEmailValid(it.toString())) {
                Log.e("sdfghj", "onCreate: $it")
                viewModel.errorMsg.value = null
            } else {
                viewModel.errorMsg.value = "Email is not valid"
            }
        }

        viewModel.etTextInput.observe(this, Observer {
            Log.e("asdfghjkl", "onCreate: " + it.toString())
        })


    }
}