package com.example.recyclerview

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.ListView
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    val countrySource = listOf<CountryInfo>(
        CountryInfo("Nguyễn Văn A", 2010,"Gia Lai",R.drawable.vietnam),
        CountryInfo("Nguyễn Văn B",2020,"ĐakLak",R.drawable.korea),
        CountryInfo("Nguyễn Văn C",2000,"Quảng ninh",R.drawable.japan),
        CountryInfo("Nguyễn Văn D",2013, "Hội an",R.drawable.laos),
        CountryInfo("Nguyễn Văn E",2009,"Đà nẵng",R.drawable.thailand)
    )
            private var listData: MutableList<CountryInfo> = countrySource as MutableList<CountryInfo>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val countryRecyclerView = findViewById<RecyclerView>(R.id.countryRV)
        val countryAdapter = CountryRVAdapter(this,countrySource)
        countryRecyclerView.layoutManager = GridLayoutManager(this,1)
        countryRecyclerView.adapter = countryAdapter
        countryAdapter.onItemClick={sv ->
            val detailIntent = Intent(this,SvDetails::class.java)
            detailIntent.putExtra("name",sv.name)
            detailIntent.putExtra("address",sv.inforSv)
            detailIntent.putExtra("image",sv.flag)

//            detailIntent.putExtra("desc",article.desc)
//            detailIntent.putExtra("imgURL",article.imgURL)
            startActivity(detailIntent)

        }
        // add user
    val btn = findViewById<Button>(R.id.add_user)
//        val countrySource = listOf<CountryInfo>(
//                CountryInfo("Nguyễn Văn A", 2010,"Gia Lai",R.drawable.vietnam),
//                CountryInfo("Nguyễn Văn B",2020,"ĐakLak",R.drawable.korea),
//                CountryInfo("Nguyễn Văn C",2000,"Quảng ninh",R.drawable.japan),
//                CountryInfo("Nguyễn Văn D",2013, "Hội an",R.drawable.laos),
//                CountryInfo("Nguyễn Văn E",2009,"Đà nẵng",R.drawable.thailand)

//        )
//        val list: MutableList<String> = countrySource
        btn.setOnClickListener {
//            listData.add( CountryInfo("Nguyễn Văn A1", 2010,"Gia Lai",R.drawable.vietnam))

//            Toast.makeText(this, "ỨNG DỤNG ĐƯỢC TẠO BỞI MR KATSU", Toast.LENGTH_SHORT).show()

        }
//        println(listData[4].name)

    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.option_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }
    @SuppressLint("ResourceAsColor")
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val countryRecyclerView = findViewById<RecyclerView>(R.id.countryRV)
        when(item.itemId){
            R.id.option_backgroudcolor -> {
                countryRecyclerView.setBackgroundColor(R.color.black)
            }
            R.id.option_About -> {

                Toast.makeText(this, "ỨNG DỤNG ĐƯỢC TẠO BỞI ", Toast.LENGTH_SHORT).show()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}