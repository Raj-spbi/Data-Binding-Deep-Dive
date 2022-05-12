package com.example.conduit.databinding.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.conduit.BR
import com.example.conduit.R
import com.example.conduit.databinding.RecycItemBinding
import com.example.conduit.databinding.viewmodel.MainViewModel

class AdapterRecycler(
    var data: ArrayList<RecyclerData>,
    var viewModel1: MainViewModel
) : RecyclerView.Adapter<AdapterRecycler.ExViewHolder>() {

    class ExViewHolder(var binding: RecycItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(viewModel1: MainViewModel, position: Int) {
            binding.itemViewModel = viewModel1
            binding.position = position

          /*  binding.setVariable(BR.viewModel, viewModel1)
            binding.setVariable(BR.position, position)*/     //Don't know why it is not working
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExViewHolder {
        val view = DataBindingUtil.inflate<RecycItemBinding>(
            LayoutInflater.from(parent.context),
            R.layout.recyc_item, parent, false
        )
        return ExViewHolder(view)

    }

    override fun onBindViewHolder(holder: ExViewHolder, position: Int) {
        holder.bind(viewModel1, position)
    }

    override fun getItemCount(): Int {
        return data.size
    }
}