package hoi.android.bai1picasso

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import com.squareup.picasso.Picasso

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val imageView = findViewById<ImageView>(R.id.imageView)
        findViewById<Button>(R.id.loadImage).setOnClickListener{
         Picasso.get().load("data:image/jpeg;base64,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")
               .placeholder(R.drawable.cute)
            .error(R.drawable.error)
            .into(imageView)
        }
    }
}