package com.gmail.vttphuong.lession4_exercise2b_phuong_n4ued

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    val countrySource = listOf<CountryInfo>(
            CountryInfo("Viet Nam",96.2,R.drawable.vietnam),
            CountryInfo("Korea",65.2,R.drawable.korea),
            CountryInfo("Japan",27.8,R.drawable.japan),
            CountryInfo("Laos",30.5,R.drawable.laos),
            CountryInfo("Thailand",50.5,R.drawable.thailand)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val countryRecyclerView = findViewById<RecyclerView>(R.id.countryRV)
        val countryAdapter = CountryRVAdapter(this,countrySource)
        countryRecyclerView.layoutManager = GridLayoutManager(this,2)
        countryRecyclerView.adapter = countryAdapter
    }
}