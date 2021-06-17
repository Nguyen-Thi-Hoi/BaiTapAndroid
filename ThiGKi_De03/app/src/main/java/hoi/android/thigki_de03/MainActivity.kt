package hoi.android.thigki_de03

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    val countrySource = listOf<StaffsInfo>(
        StaffsInfo("Nguyễn Văn Sinh", 1994,"Quê quán Đại Hưng, chức vụ: Công an xã.",R.drawable.staff1),
        StaffsInfo("Nguyễn Thị Hòa",21991,"Quê quán Đại Sơn, chức vụ: Chủ tịch hội LHPN xã",R.drawable.staff2),
        StaffsInfo("Nguyễn Văn Sen",1966,"Quê quán Đại Lãnh, chức vụ: Ban thanh tra trường tiểu học NQT",R.drawable.staff3),
        StaffsInfo("Nguyễn Thị Nhân",1995, "Quê quán Đại Đồng, chức vụ: Nhân viên văn phòng",R.drawable.staff4),
        StaffsInfo("Nguyễn Thị Ái",1996,"Quê quán Đại Hồng, chúc vụ: Giáo viên chủ nhiệm.",R.drawable.staff5),
        StaffsInfo("Nguyễn Thị Hội",1997,"Quê quán Đại Quang, chức vụ: Kế toán",R.drawable.staff6),
        StaffsInfo("Nguyễn Thị Nhân",1994,"Quê quán Đại Nghĩa, chức vụ: Chủ tịch xã Đại Nghĩa.",R.drawable.staff7)

    )
    private var listData: MutableList<StaffsInfo> = countrySource as MutableList<StaffsInfo>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val staffsRecyclerView = findViewById<RecyclerView>(R.id.staffsRV)
        val staffsAdapter = StaffsRVAdapter(this,countrySource)
        staffsRecyclerView.layoutManager = GridLayoutManager(this,1)
        staffsRecyclerView.adapter = staffsAdapter
        staffsAdapter.onItemClick={staff ->
            val detailIntent = Intent(this,StaffsDetails::class.java)
            detailIntent.putExtra("image", staff.flag)
            detailIntent.putExtra("name",staff.name)
            detailIntent.putExtra("year",staff.year)
            detailIntent.putExtra("address",staff.inforStaffs)

        }
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.option_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }
    @SuppressLint("ResourceAsColor")
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val staffsRecyclerView = findViewById<RecyclerView>(R.id.staffsRV)
        when(item.itemId){
            R.id.option_backgroudcolor -> {
                staffsRecyclerView.setBackgroundColor(R.color.black)
            }
            R.id.option_About -> {

                Toast.makeText(this, "Đã hiện thị thông tin", Toast.LENGTH_SHORT).show()
            }
        }
        return super.onOptionsItemSelected(item)
    }

}