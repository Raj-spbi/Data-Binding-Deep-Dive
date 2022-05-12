package com.example.conduit.databinding.recycler

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.conduit.R
import com.example.conduit.databinding.ActivityActivity2RecyclerBinding
import com.example.conduit.databinding.viewmodel.MainViewModel
import com.example.conduit.databinding.viewmodelFactory.MainViewModelFactory

class Activity2Recycler : AppCompatActivity(), OnItemClickListenerT {
    lateinit var binding: ActivityActivity2RecyclerBinding
    lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_activity2_recycler)
        viewModel =
            ViewModelProvider(this, MainViewModelFactory(this)).get(MainViewModel::class.java)

        binding.itemViewModel = viewModel
        binding.recylclerView.layoutManager = LinearLayoutManager(this)
        binding.lifecycleOwner = this
        binding.mContext = this


    }

    override fun onItemClick(position: Int) {
        Toast.makeText(this, "Hello: " + viewModel.mData.get(position).name, Toast.LENGTH_SHORT)
            .show()
    }
}

interface OnItemClickListenerT {
    fun onItemClick(position: Int)
}
