package hoi.android.thigki_de03

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class StaffsDetails : AppCompatActivity() {
    var imgURI: Uri? = null
    val IMG_PICK_CODE = 100
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.staffsdetails)
        if(intent != null){
            findViewById<TextView>(R.id.nameStaffs).text = intent.getStringExtra("name")
            findViewById<TextView>(R.id.inforStaffs).text = intent.getStringExtra("address")

            val imgView = findViewById<ImageView>(R.id.imageInfo)
            val image_link = getIntent().getIntExtra("image", 0);
            imgView.setImageResource(image_link);

        }
        findViewById<Button>(R.id.chooselogo).setOnClickListener{
            val imgIntent = Intent(Intent.ACTION_PICK,
                    MediaStore.Images.Media.INTERNAL_CONTENT_URI)
            startActivityForResult(imgIntent,IMG_PICK_CODE)
        }

    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(  resultCode == Activity.RESULT_OK){
            imgURI = data?.data
            findViewById<ImageView>(R.id.imageInfo).setImageURI(imgURI)
        }
    }
}


