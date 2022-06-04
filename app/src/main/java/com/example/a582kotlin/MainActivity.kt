package com.example.a582kotlin

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.a581kotlin.FeedsAdapter
import com.example.a581kotlin.Stories
import com.example.a581kotlin.StoriesAdapter

class MainActivity : AppCompatActivity() {
    lateinit var recyclerViewFeeds: RecyclerView
    lateinit var recyclerViewStories: RecyclerView
    lateinit var pickUpImages: ImageView
    lateinit var textViewPost: TextView
    lateinit var uri: ArrayList<Uri>
    lateinit var adapterFeeds: FeedsAdapter
    private var Read_Permission = 101

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
        pickImages()
    }

    private fun pickImages() {
        recyclerViewFeeds = findViewById(R.id.feeds_recyclerView)
        recyclerViewFeeds.layoutManager = GridLayoutManager(this, 2)

        pickUpImages = findViewById(R.id.pickImages)
        textViewPost = findViewById(R.id.posts_Number)

        adapterFeeds = FeedsAdapter(uri)
        recyclerViewFeeds.adapter = adapterFeeds
        allowToGallery()
    }
    private fun allowToGallery() {


        if (ContextCompat.checkSelfPermission(this@MainActivity, android.Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this@MainActivity, arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE), Read_Permission) }


        pickUpImages.setOnClickListener {
            val intent = Intent(Intent.ACTION_GET_CONTENT)
            intent.type = "images/*"
            intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true)
            startActivityForResult(Intent.createChooser(intent, "Select Picture"), 1)
        }

    }
    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1 && resultCode == RESULT_OK) {
            if (data!!.clipData != null) {
                val count = data.clipData!!.itemCount
                for (i in 0 until count) {
                    uri.add(data.clipData!!.getItemAt(i).uri)
                }
                adapterFeeds.notifyDataSetChanged()
                textViewPost.text = "Post(" + uri.size + ")"
            } else if (data.data != null) {
                val imageURL = data.data!!.path
                uri.add(Uri.parse(imageURL))
            }
        }
    }


    private fun initViews() {
        recyclerViewStories = findViewById(R.id.story_recyclerView)
        recyclerViewStories.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        getStoriesAdapter(dataOfStories())
    }

    private fun dataOfStories(): ArrayList<Stories> {
        val storiesList: ArrayList<Stories> = ArrayList()
        storiesList.add(Stories(R.drawable.rasm, "Alisher"))
        storiesList.add(Stories(R.drawable.rasm1, "Abbos Daminov"))
        storiesList.add(Stories(R.drawable.rasm2, "Begzodbek"))
        storiesList.add(Stories(R.drawable.rasm, "Alisher"))
        storiesList.add(Stories(R.drawable.rasm1, "Abbos Daminov"))
        storiesList.add(Stories(R.drawable.rasm2, "Begzodbek"))
        storiesList.add(Stories(R.drawable.rasm, "Alisher"))
        storiesList.add(Stories(R.drawable.rasm1, "Abbos Daminov"))
        storiesList.add(Stories(R.drawable.rasm2, "Begzodbek"))
        storiesList.add(Stories(R.drawable.rasm, "Alisher"))
        storiesList.add(Stories(R.drawable.rasm1, "Abbos Daminov"))
        storiesList.add(Stories(R.drawable.rasm2, "Begzodbek"))
        return storiesList
    }

    private fun getStoriesAdapter(stories: ArrayList<Stories>) {
        val adapter = StoriesAdapter(this, stories)
        recyclerViewStories.adapter = adapter
    }


}