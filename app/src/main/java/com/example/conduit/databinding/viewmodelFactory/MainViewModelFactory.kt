package com.example.conduit.databinding.viewmodelFactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.conduit.databinding.onItemClickListenerT
import com.example.conduit.databinding.recycler.OnItemClickListenerT
import com.example.conduit.databinding.viewmodel.MainViewModel


class MainViewModelFactory(var onItemClickListenerT: OnItemClickListenerT) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(onItemClickListenerT) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}