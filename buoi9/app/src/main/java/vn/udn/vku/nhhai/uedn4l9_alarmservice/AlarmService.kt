package vn.udn.vku.nhhai.uedn4l9_alarmservice

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.Handler
import android.os.IBinder
import android.os.Looper
import java.lang.UnsupportedOperationException
import java.util.*

class AlarmService : Service() {
    var hour = 0
    var minute = 0
    lateinit var player: MediaPlayer
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        if(intent != null){
            player = MediaPlayer.create(this,R.raw.alarm_mario)
            hour = intent.getIntExtra("hour",0)
            minute = intent.getIntExtra("minute",0)
            checkTimer()
        }
        return START_STICKY
    }
    override fun onDestroy() {
        player.stop()
        super.onDestroy()
    }
    override fun onBind(intent: Intent): IBinder {
        throw UnsupportedOperationException("Not supported")
    }
    private fun checkTimer(){
        val mainHandler = Handler(Looper.getMainLooper())
        mainHandler.post(object:Runnable{
            override fun run() {
                val calendar = Calendar.getInstance()
                val currentHour = calendar.get(Calendar.HOUR_OF_DAY)
                val currentMinute = calendar.get(Calendar.MINUTE)
                if(hour == currentHour && minute == currentMinute){
                    player.start()
                }
                else{
                    mainHandler.postDelayed(this,1000)
                }
            }
        })
    }
}