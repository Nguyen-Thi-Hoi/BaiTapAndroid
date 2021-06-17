package com.gmail.vttphuong.lession4_exercise2a_phuong_n4ued

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    val countrySource = listOf<CountryInfo>(
        CountryInfo("Viet Nam",96.3,R.drawable.vietnam),
        CountryInfo("Korea",10.5,R.drawable.korea),
        CountryInfo("Japan",60.5,R.drawable.japan),
        CountryInfo("Laos",57.8,R.drawable.laos),
        CountryInfo("Thailand",27.8,R.drawable.thailand)
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val countryListView = findViewById<ListView>(R.id.countryLV)
        val countryAdapter = CountryAdapter(this,countrySource)
        countryListView.adapter = countryAdapter
    }
}