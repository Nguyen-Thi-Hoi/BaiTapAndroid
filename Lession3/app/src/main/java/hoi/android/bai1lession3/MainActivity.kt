package hoi.android.bai1lession3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Switch
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val hideSwitch = findViewById<Switch>(R.id.hideImgSwitch)
        val image = findViewById<ImageView>(R.id.imageView)
        hideSwitch.setOnCheckedChangeListener{_,isChecked ->
            if(!isChecked){
                image.visibility = View.VISIBLE
            }
            else{
                image.visibility = View.INVISIBLE
            }
        }
    }
    fun chooseTurtle(view: View) {
        val chooseText = findViewById<TextView>(R.id.txtChoose)
        val image = findViewById<ImageView>(R.id.imageView)
        when(view.id){
            R.id.btnXanh ->{
                chooseText.text = "Ban chon mau Xanh!"
                image.setImageResource(R.drawable.xanh)
            }
            R.id.btnDo ->{
                chooseText.text = "Ban chon mau Do!"
                image.setImageResource(R.drawable.ddo)
            }
            R.id.btnTim ->{
                chooseText.text = "Ban chon mau Tim!"
                image.setImageResource(R.drawable.tim)
            }
            R.id.btnVang ->{
                chooseText.text = "Ban chon mau Vang!"
                image.setImageResource(R.drawable.vang)
            }
        }
        val hideSwitch = findViewById<Switch>(R.id.hideImgSwitch)
        if(hideSwitch.isChecked){
            image.visibility = View.INVISIBLE
        }
        else{
            image.visibility = View.VISIBLE
        }
    }
}