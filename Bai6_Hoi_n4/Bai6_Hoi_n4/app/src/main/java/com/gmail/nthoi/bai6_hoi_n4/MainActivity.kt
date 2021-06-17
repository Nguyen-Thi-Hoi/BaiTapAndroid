package com.gmail.nthoi.bai6_hoi_n4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.gmail.vttphuong.lesson6_photoapp_phuong_n4ued.ArticleAdapter
import com.gmail.vttphuong.lesson6_photoapp_phuong_n4ued.ArticleDetailActivity
import com.gmail.vttphuong.lesson6_photoapp_phuong_n4ued.ArticleInfo
import org.json.JSONException

class MainActivity : AppCompatActivity() {
    val articleSource = arrayListOf<ArticleInfo>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView = findViewById<RecyclerView>(R.id.articleRecyclerView)
        recyclerView.layoutManager = GridLayoutManager(this,2)
        val url = "https://fontkeyboard.org/wsv/?json_name=articles"
        val requestQueue = Volley.newRequestQueue(this)
        val request = JsonObjectRequest(Request.Method.GET,url,null,
                Response.Listener{response ->
                    try {
                        val jsonArray = response.getJSONArray("articles")
                        for (i in 0 until jsonArray.length()){
                            val article = jsonArray.getJSONObject(i)
                            val id = article.getInt("article_id")
                            val title = article.getString("article_title")
                            val imageURL = article.getString("article_image")
                            val desc = article.getString("article_description")
                            val articleInfo = ArticleInfo(id,title,imageURL,desc)
                            articleSource.add(articleInfo)
                        }
                        val articleAdapter = ArticleAdapter(this,articleSource)
                        recyclerView.adapter = articleAdapter
                        articleAdapter.onItemClick={article ->
                            val detailIntent = Intent(this, ArticleDetailActivity::class.java)
                            detailIntent.putExtra("title",article.title)
                            detailIntent.putExtra("desc",article.desc)
                            detailIntent.putExtra("imgURL",article.imgURL)
                            startActivity(detailIntent)
                        }
                    }
                    catch (e:JSONException){
                        e.printStackTrace()
                    }
                },
                Response.ErrorListener {error ->
                    error.printStackTrace()
                })
        requestQueue.add(request)
    }
}