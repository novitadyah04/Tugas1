package com.example.cityrecycleview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private val items:MutableList<Item> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val list = findViewById<RecyclerView>(R.id.flower_list)
        initData()

        list.layoutManager = LinearLayoutManager(this)
        list.adapter = RecycleViewAdapter(this,items)
    }
    private fun initData(){
        val name = resources.getStringArray(R.array.city_name)
        val image = resources.obtainTypedArray(R.array.city_image)
        items.clear()

        for (i in name.indices){
            items.add(
                Item(name[i],
                    image.getResourceId(i, 0))
            )
        }

        image.recycle()
    }
}
