package com.gmail.thuthuy.recyclerview

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    val thptSource = listOf<ThptInfo>(
        ThptInfo("PCT", "123 To Huu", "acb", R.drawable.kiwi),
        ThptInfo("HKT", "568 Le Duan", "sdjei", R.drawable.bg),
        ThptInfo("TP", "123 DBP", "erer", R.drawable.cat2),
        ThptInfo("LQD", "456 HHT", "roo", R.drawable.cat4),
        ThptInfo("TRP", "789 LL", "ropo", R.drawable.flower),
        ThptInfo("NH", "147 TP", "weork", R.drawable.mik),
        ThptInfo("LL", "178 To Huu", "eirie", R.drawable.thap),

        )
    private var listData: MutableList<ThptInfo> = thptSource as MutableList<ThptInfo>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val thptRecyclerView = findViewById<RecyclerView>(R.id.thptRV)
        val thptAdapter = ThptRVAdapter(this, thptSource)
        thptRecyclerView.layoutManager = GridLayoutManager(this, 1)

        thptRecyclerView.adapter = thptAdapter
        thptAdapter.onItemClick = { des ->
            val detailIntent = Intent(this, Details::class.java)
            detailIntent.putExtra("name", des.name)
            detailIntent.putExtra("details", des.details)
            detailIntent.putExtra("image", des.flag)
            startActivity(detailIntent)
        }
        val btn = findViewById<Button>(R.id.add)

        btn.setOnClickListener {


        }
        fun onCreateOptionsMenu(menu: Menu?): Boolean {
            menuInflater.inflate(R.menu.menu_option, menu)
            return super.onCreateOptionsMenu(menu)
        }

//       @SuppressLint("ResourceAsColor")
//        fun onOptionsItemSelected(item: MenuItem): Boolean {
//            val countryRecyclerView = findViewById<RecyclerView>(R.id.thptRV)
//            when (item.itemId) {
//                R.id.option_backgroundcolor -> {
//                    countryRecyclerView.setBackgroundColor(R.color.black)
//                }
//                R.id.option_About -> {
//
//                    Toast.makeText(this, "Day la ung dung hien thi thong tin cac truong THPT", Toast.LENGTH_SHORT)
//                        .show()
//                }
//            }
//            return super.onOptionsItemSelected(item)
//        }
    }
}