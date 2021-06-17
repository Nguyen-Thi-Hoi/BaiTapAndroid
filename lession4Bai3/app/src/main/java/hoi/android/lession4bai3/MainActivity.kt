package hoi.android.lession4bai3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    val countrySource = listOf<CountryInfo>(
            CountryInfo("Viet Nam",96.5,R.drawable.vietnam),
            CountryInfo("Korea",61.2,R.drawable.korea),
            CountryInfo("Japan",105.7,R.drawable.japan),
            CountryInfo("Laos",12.4,R.drawable.laos),
            CountryInfo("Thailand",65.9,R.drawable.thailand)
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