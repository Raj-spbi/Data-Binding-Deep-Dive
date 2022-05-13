package com.example.conduit.diffutiltest.Util

import android.os.Bundle
import android.util.Log
import androidx.annotation.Nullable
import androidx.recyclerview.widget.DiffUtil
import com.example.conduit.diffutiltest.Person


class MyDiffUtilCallback(
    private val oldList: List<Person>,
    private val newList: List<Person>
) : DiffUtil.Callback() {


    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        Log.d(
            "areItemsTheSame",
            "" + oldList[oldItemPosition].id.equals(newList[newItemPosition].id)
        )
        return oldList[oldItemPosition].id == newList[newItemPosition].id
    }


    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        /*  for (i in  0 until newItemPosition)*/

        val status = when {
            oldList[oldItemPosition].id != newList[newItemPosition].id -> {
                false
            }
            oldList[oldItemPosition].name != newList[newItemPosition].name -> {
                false
            }
            oldList[oldItemPosition].age != newList[newItemPosition].age -> {
                false
            }
            else ->
                true

        }
        Log.d("areItemsTheSame1", "" + status)
        return status
    }


    @Nullable
    override fun getChangePayload(oldItemPosition: Int, newItemPosition: Int): Any? {
        val newModel: Person = newList[newItemPosition]
        val oldModel: Person = oldList[oldItemPosition]
        val diff = Bundle()
        if (newModel.name !== oldModel.name) {
            diff.putString("name", newModel.name)
        }
        return if (diff.size() == 0) {
            null
        } else diff
    }
}