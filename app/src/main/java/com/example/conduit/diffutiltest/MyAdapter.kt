package com.example.conduit.diffutiltest

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.conduit.databinding.ItemDiffRecyclerviewBinding
import com.example.conduit.diffutiltest.Util.MyDiffUtilCallback

class MyAdapter : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    private var oldPersonList = emptyList<Person>()

    class MyViewHolder(val itemDiffRecyclerviewBinding: ItemDiffRecyclerviewBinding) :
        RecyclerView.ViewHolder(itemDiffRecyclerviewBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            ItemDiffRecyclerviewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        Log.d("prince",""+position)
        holder.itemDiffRecyclerviewBinding.myTv.text = oldPersonList.get(position).name
    }

    override fun getItemCount(): Int {
        return oldPersonList.size
    }

    fun setData(newPersonList: List<Person>) {
        val diffUtil = MyDiffUtilCallback(oldPersonList, newPersonList)
        val diffResults = DiffUtil.calculateDiff(diffUtil)
        oldPersonList = newPersonList
        diffResults.dispatchUpdatesTo(this)
    }
}