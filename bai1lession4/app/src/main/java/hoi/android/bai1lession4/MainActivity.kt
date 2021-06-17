package hoi.android.bai1lession4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    val countrySource = listOf<String>(
        "Sanghai", "Hangzhou", "Guangdong", "Guizhou", "Lanzhou", "Gansu", "Hubei", "Wuhan",
        "Shanxi", "Zheijang", "Macao", "Hong Kong"
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val countryListView = findViewById<ListView>(R.id.countryLV)
        val countryAdapter = ArrayAdapter<String>(this,R.layout.row_item_country,
            R.id.nameTV,countrySource)
        countryListView.adapter = countryAdapter
    }
}