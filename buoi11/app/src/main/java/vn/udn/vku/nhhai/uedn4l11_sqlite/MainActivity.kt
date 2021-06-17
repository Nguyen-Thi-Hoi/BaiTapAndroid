package vn.udn.vku.nhhai.uedn4l11_sqlite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val dbHandler = DatabaseHandler(this)
        val insertBtn = findViewById<Button>(R.id.insertBtn)
        val readBtn = findViewById<Button>(R.id.readBtn)
        val updateBtn = findViewById<Button>(R.id.updateBtn)
        val deleteBtn = findViewById<Button>(R.id.deleteBtn)
        insertBtn.setOnClickListener {
            val nameET = findViewById<EditText>(R.id.nameET)
            val yearET = findViewById<EditText>(R.id.yearET)
            if(nameET.text.isNotEmpty() && yearET.text.isNotEmpty()){
                val user = User(nameET.text.toString(),yearET.text.toString().toInt())
                dbHandler.insertData(user)
                nameET.setText("")
                yearET.setText("")
                readBtn.performClick()
            }
        }
        readBtn.setOnClickListener {
            val users = dbHandler.readData()
            val contentTV = findViewById<TextView>(R.id.contentTV)
            contentTV.text = ""
            for (i in 0 until users.size){
                contentTV.append(users[i].name + " "+users[i].birthYear + "\n")
            }
        }
        updateBtn.setOnClickListener {
            dbHandler.updateData()
            readBtn.performClick()
        }
        deleteBtn.setOnClickListener {
            val name = findViewById<EditText>(R.id.nameET).text.toString()
            dbHandler.deleteData(name)
            readBtn.performClick()
        }
    }
}