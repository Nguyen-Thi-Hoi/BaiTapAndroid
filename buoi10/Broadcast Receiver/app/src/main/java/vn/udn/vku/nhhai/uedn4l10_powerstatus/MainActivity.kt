package vn.udn.vku.nhhai.uedn4l10_powerstatus

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Switch

class MainActivity : AppCompatActivity() {
    private lateinit var powerStatusReceiver: BroadcastReceiver
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val filter = IntentFilter()
        filter.addAction(Intent.ACTION_POWER_CONNECTED)
        filter.addAction(Intent.ACTION_POWER_DISCONNECTED)
        powerStatusReceiver = PowerStatusReceiver()
        registerReceiver(powerStatusReceiver,filter)
    }

    override fun onDestroy() {
        unregisterReceiver(powerStatusReceiver)
        super.onDestroy()
    }
}