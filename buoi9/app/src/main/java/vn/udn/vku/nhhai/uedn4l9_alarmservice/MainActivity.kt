package vn.udn.vku.nhhai.uedn4l9_alarmservice

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.MediaController
import android.widget.TimePicker
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var timePicker: TimePicker

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val setBtn = findViewById<Button>(R.id.setAlarmBtn)
        val stopBtn = findViewById<Button>(R.id.stopAlarmBtn)
        timePicker = findViewById<TimePicker>(R.id.timePicker)
        val timerServiceIntent = Intent(this,AlarmService::class.java)
        setBtn.setOnClickListener{
            val hour = timePicker.hour
            val minute = timePicker.minute
            timerServiceIntent.putExtra("hour",hour)
            timerServiceIntent.putExtra("minute",minute)
            startService(timerServiceIntent)
        }
        stopBtn.setOnClickListener {
            stopService(timerServiceIntent)
        }
    }
}