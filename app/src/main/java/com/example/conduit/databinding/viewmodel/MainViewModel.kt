package com.example.conduit.databinding.viewmodel

import androidx.lifecycle.ViewModel
import com.example.conduit.databinding.recycler.AdapterRecycler
import com.example.conduit.databinding.recycler.OnItemClickListenerT
import com.example.conduit.databinding.recycler.RecyclerData

class MainViewModel(var onItemClickListenerT: OnItemClickListenerT) : ViewModel() {
    var mData: ArrayList<RecyclerData> = ArrayList()


    init {
        mData.add(RecyclerData("Raj", "Raj.spbi@gmail.com", true))
        mData.add(RecyclerData("Kshitij", "Kshitij.spbi@gmail.com", false))
        mData.add(RecyclerData("Neeraj", "Neeraj.spbi@gmail.com", true))
        mData.add(RecyclerData("Suraj", "Suraj.spbi@gmail.com", true))
        mData.add(RecyclerData("Abhinay", "Abhinay.spbi@gmail.com", false))
        mData.add(RecyclerData("Vibhu", "Vibhu.spbi@gmail.com", true))
    }

    var adapterRecycler = AdapterRecycler(mData, this)

    fun setAdapter(): AdapterRecycler {
        return adapterRecycler
    }

    fun onClick(position: Int) {
        onItemClickListenerT.onItemClick(position)
//        Toast.makeText(context, "Hello: " + mData.get(position).name, Toast.LENGTH_SHORT).show()
    }

    fun setCheckBoxStatus(position: Int): Boolean {
        return if (mData.size > position) {
            mData.get(position).status
        } else {
            false
        }
    }

    fun setTitle(position: Int): String {
        return mData.get(position).name
    }

    fun setEmail(position: Int): String {
        return mData.get(position).email
    }
}
