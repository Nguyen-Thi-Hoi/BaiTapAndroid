package com.gmail.hthong.lesson7exercise2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.ProgressBar
import java.util.concurrent.Executors

class MainActivity : AppCompatActivity() {
    private lateinit var progressBar: ProgressBar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val startBtn = findViewById<Button>(R.id.startBtn)
        progressBar = findViewById<ProgressBar>(R.id.progressBar)
        startBtn.setOnClickListener {
            progressBar.progress = 0
            startHeavyDownload()
        }
    }
    private fun startHeavyDownload(){
        val executor = Executors.newSingleThreadExecutor()
        val handler = Handler(Looper.getMainLooper())
        executor.execute {
            for (i in 1..10){
                handler.post{
                    progressBar.progress = 10 * i
                }
                Thread.sleep(1000)
            }
        }
    }
}