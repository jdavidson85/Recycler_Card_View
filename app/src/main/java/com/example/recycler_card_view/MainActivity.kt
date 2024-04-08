package com.example.recycler_card_view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)

        // Set up the RecyclerView with a LinearLayoutManager
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Populate the RecyclerView with data
        val imageList = mutableListOf<ImageItem>()
        for (i in 1..25) {
            // Get the resource ID of the image dynamically
            val resourceId = resources.getIdentifier("image$i", "drawable", packageName)
            val caption = "Image $i"
            imageList.add(ImageItem(resourceId, caption))
        }

        val adapter = ImageAdapter(imageList)
        recyclerView.adapter = adapter
    }
}