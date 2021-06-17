package vn.udn.vku.nhhai.uedn4_permissions

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

const val CAMERA_STORAGE_PERMISSION_CODE = 100
class MainActivity : AppCompatActivity() {
    private var permissionArray = arrayOf(Manifest.permission.CAMERA,Manifest.permission.READ_EXTERNAL_STORAGE)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val requestBtn = findViewById<Button>(R.id.requestBtn)
        val cameraBtn = findViewById<Button>(R.id.cameraBtn)
        val openFileBtn = findViewById<Button>(R.id.openFileBtn)
        cameraBtn.setOnClickListener {
            val camIntent = Intent("android.media.action.IMAGE_CAPTURE")
            startActivity(camIntent)
        }
        requestBtn.setOnClickListener {
            if(checkPermission(permissionArray)){
                Toast.makeText(this,"All permissions were already granted",Toast.LENGTH_SHORT).show()
            }
            else{
                requestPermissions(permissionArray, CAMERA_STORAGE_PERMISSION_CODE)
            }
        }
        openFileBtn.setOnClickListener {
            val openFileIntent = Intent(Intent.ACTION_GET_CONTENT)
            openFileIntent.type = "*/*"
            startActivity(openFileIntent)
        }
    }
    private fun checkPermission(permissionArray: Array<String>): Boolean{
        var allGranted = true
        for (i in permissionArray.indices){
            if(checkCallingOrSelfPermission(permissionArray[i])==PackageManager.PERMISSION_DENIED){
                allGranted = false
            }
        }
        return allGranted
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>,
                                            grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(requestCode == CAMERA_STORAGE_PERMISSION_CODE){
            var allGranted = true
            for (i in permissions.indices){
                if(grantResults[i]==PackageManager.PERMISSION_DENIED){
                    allGranted = false
                    var shouldRequestLater = shouldShowRequestPermissionRationale(permissions[i])
                    if(shouldRequestLater){
                        Toast.makeText(this,"Permission denied",Toast.LENGTH_SHORT).show()
                    }
                    else{
                        Toast.makeText(this,
                            "Please go to settings to enable permissions so that this function can work",
                            Toast.LENGTH_SHORT).show()
                    }
                }
            }
            if(allGranted){
                Toast.makeText(this,"All permissions are granted",Toast.LENGTH_SHORT).show()
            }
        }
    }
}