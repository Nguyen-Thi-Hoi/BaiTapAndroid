package com.gmail.nthoi.bai6_hoi_n4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.gmail.nthoi.bai6_hoi_n4.R
import com.squareup.picasso.Picasso

class ArticleDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article_detail)
        if(intent != null){
            findViewById<TextView>(R.id.detailTitle).text = intent.getStringExtra("title")
            findViewById<TextView>(R.id.detailDescription).text = intent.getStringExtra("desc")
            val imgView = findViewById<ImageView>(R.id.detailImage)
            Picasso.get().load(intent.getStringExtra("imgURL")).into(imgView)
        }
    }
}