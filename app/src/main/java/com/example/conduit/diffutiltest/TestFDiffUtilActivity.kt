package com.example.conduit.diffutiltest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.conduit.R
import com.example.conduit.databinding.ActivityTestFdiffUtilBinding

class TestFDiffUtilActivity : AppCompatActivity() {

    private val myAdapter by lazy { MyAdapter() }
    lateinit var binding: ActivityTestFdiffUtilBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_test_fdiff_util)
        binding.recyclerView.setHasFixedSize(true)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = myAdapter

        val p1 = Person(1, "Rajat", 24)
        val p2 = Person(2, "Sumit", 25)
        val p3 = Person(3, "Suraj", 26)
        val p4 = Person(4, "Praveen", 32)
        val p5 = Person(5, "Ajay", 21)

        val p6 = Person(6, "Rajkamal", 43)
        val p7 = Person(7, "Vibhu", 54)
        val p8 = Person(8, "Abhishek", 55)
        val p9 = Person(9, "Dhruva", 66)
        val p10 = Person(10, "Abhinay", 46)
        val p11 = Person(11, "Soni ", 83)
        val p12 = Person(12, "Rudransh", 13)
        val p13 = Person(5, "Pandey", 21)
        val p14 = Person(6, "Manoj", 43)
        val p15 = Person(7, "Raju", 54)
        val p16 = Person(8, "Ranjeet", 55)
        val p17 = Person(9, "Sujeet", 66)
        val p18 = Person(10, "Deelip", 46)
        val p19 = Person(11, "Rahul ", 83)
        myAdapter.setData(listOf(p1, p2, p3, p4, p5))




        binding.button.setOnClickListener {


            val p5 = Person(5, "AjayNew", 21)
            myAdapter.setData(listOf(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12))
            binding.recyclerView.smoothScrollToPosition(myAdapter.itemCount - 1)
        }
        binding.button2.setOnClickListener {
            myAdapter.setData(
                listOf(
                    p1,
                    p2,
                    p3,
                    p4,
                    p5,
                    p6,
                    p7,
                    p8,
                    p9,
                    p10,
                    p11,
                    p12,
                    p13,
                    p14,
                    p15,
                    p16,
                    p17,
                    p18,
                    p19
                )
            )
            binding.recyclerView.smoothScrollToPosition(myAdapter.itemCount - 1)
        }
    }
}