package hoi.android.bai2lession3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*
import androidx.core.view.isVisible

class MainActivity : AppCompatActivity() {
    lateinit var vuiBar:SeekBar
    lateinit var buonBar:SeekBar
    lateinit var hahaBar:SeekBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        vuiBar = findViewById<SeekBar>(R.id.vuiSeekBar)
        buonBar = findViewById<SeekBar>(R.id.buonSeekBar)
        hahaBar = findViewById<SeekBar>(R.id.hahaSeekBar)

        vuiBar.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                val vuiTextView = findViewById<TextView>(R.id.txtVui)
                vuiTextView.text = progress.toString() + "%"
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

        buonBar.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                val buonTextView = findViewById<TextView>(R.id.txtBuon)
                buonTextView.text = progress.toString() + "%"
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

        hahaBar.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                val hahaTextView = findViewById<TextView>(R.id.txtHaha)
                hahaTextView.text = progress.toString() + "%"
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

        val fullButton = findViewById<ImageButton>(R.id.btnFull)
        val clearButton = findViewById<ImageButton>(R.id.btnClear)
        fullButton.setOnClickListener {
            vuiBar.progress = 100
            buonBar.progress = 100
            hahaBar.progress = 100
        }
        clearButton.setOnClickListener{
            vuiBar.progress = 0
            buonBar.progress = 0
            hahaBar.progress = 0
        }

        val menuButton = findViewById<Button>(R.id.btnPopup)
        registerForContextMenu(menuButton)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.option_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.option_full_item -> {
                vuiBar.progress = 100
                buonBar.progress = 100
                hahaBar.progress = 100
            }
            R.id.option_half_item -> {
                vuiBar.progress = 50
                buonBar.progress = 50
                hahaBar.progress = 50
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        menuInflater.inflate(R.menu.popup_menu,menu)
        super.onCreateContextMenu(menu, v, menuInfo)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        val fullButton = findViewById<ImageButton>(R.id.btnFull)
        val clearButton = findViewById<ImageButton>(R.id.btnClear)
        when(item.itemId){
            R.id.popup_saybye_item ->{
                Toast.makeText(this,"Goodbye class",
                    Toast.LENGTH_LONG).show()
            }
            R.id.popup_hide_item -> {
                fullButton.isVisible = false
                clearButton.isVisible = false
            }
            R.id.popup_show_item -> {
                fullButton.isVisible = true
                clearButton.isVisible = true
            }
        }
        return super.onContextItemSelected(item)
    }
}