package vn.udn.vku.nhhai.uedn4l10_powerstatus

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class PowerStatusReceiver: BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        Toast.makeText(context,intent?.action,Toast.LENGTH_SHORT).show()
    }
}