package vn.udn.vku.nhhai.uedn4_fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn1 = findViewById<Button>(R.id.fragmentBtn1)
        val btn2 = findViewById<Button>(R.id.fragmentBtn2)
        val fragment1 = FirstFragment()
        val fragment2 = SecondFragment()
        btn1.setOnClickListener{
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fragmentHolder,fragment1)
                addToBackStack(null)
                commit()
            }
        }
        btn2.setOnClickListener{
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fragmentHolder,fragment2)
                addToBackStack(null)
                commit()
            }
        }
    }
}