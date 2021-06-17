package vn.udn.vku.nhhai.exercise2_uedn4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import hoi.android.bai2lession4.R

class MainActivity : AppCompatActivity() {
    val planetSource = listOf<PlanetInfo>(
        PlanetInfo("Venus",0.7, R.drawable.venus),
        PlanetInfo("Earth",1.2, R.drawable.earth),
        PlanetInfo("Mars",1.5,R.drawable.mars),
        PlanetInfo("Pluto",5.5,R.drawable.pluto),
        PlanetInfo("Saturn",9.5,R.drawable.saturn)
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val planetListView = findViewById<ListView>(R.id.planetLV)
        val planetAdapter = PlanetAdapter(this,planetSource)
        planetListView.adapter = planetAdapter
    }
}