package com.example.recyclerview

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SvDetails : AppCompatActivity() {
    var imgURI: Uri? = null
    val IMG_PICK_CODE = 100
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        super.onCreate(savedInstanceState)
        setContentView(R.layout.svdetails)
        if(intent != null){
            findViewById<TextView>(R.id.nameSV).text = intent.getStringExtra("name")
            findViewById<TextView>(R.id.addressTV).text = intent.getStringExtra("address")
//            val imgUrl = intent.getStringExtra("image")
//            int imageRef = getIntent().getIntExtra("imageId", defaultValue);

//            val imageRef = getIntent().getIntExtra("imageId", imgView);
////            imageView.setImageURI(Uri.parse(imgUrl));
            val imgView = findViewById<ImageView>(R.id.imageInfo)
            val image_link = getIntent().getIntExtra("image", 0);
            imgView.setImageResource(image_link);

//            findViewById<TextView>(R.id.detailDescription).text = intent.getStringExtra("desc")
//            val imgView = findViewById<ImageView>(R.id.imageInfo)
//            Picasso.get().load(intent.getStringExtra("imgURL")).into(imgView)
        }
        findViewById<Button>(R.id.chooselogo).setOnClickListener{
            val imgIntent = Intent(Intent.ACTION_PICK,
                    MediaStore.Images.Media.INTERNAL_CONTENT_URI)
            startActivityForResult(imgIntent,IMG_PICK_CODE)//            findViewById<ImageView>(R.id.imageInfo).setImageURI(imgURI)
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


