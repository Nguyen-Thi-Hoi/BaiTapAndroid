package hoi.android.thigki_de03

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class StaffsRVAdapter(val context: Context, val countrySource:List<StaffsInfo>)
    : RecyclerView.Adapter<StaffsRVAdapter.ViewHolder>(){
    val  listData: MutableList<StaffsInfo> = countrySource as MutableList<StaffsInfo>

    var onItemClick: ((StaffsInfo) -> Unit)? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.row_item_staffs,
            parent,false))
    }
    override fun getItemCount(): Int {
        return countrySource.count()
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.nameTV.text = countrySource[position].name
//        holder.populationTV.text = countrySource[position].population.toString() + " millions"
        holder.flagIV.setImageResource(countrySource[position].flag)

        holder.itemDelete.setOnClickListener{
            val countrySource:List<StaffsInfo>
            listData.removeAt(position)
            println(listData[0].name)
        }

    }

  inner  class ViewHolder(view: View):RecyclerView.ViewHolder(view){
        init{
            view.setOnClickListener{
                onItemClick?.invoke(countrySource[adapterPosition])
            }


        }
        val flagIV = view.findViewById<ImageView>(R.id.flagTV)
        val nameTV = view.findViewById<TextView>(R.id.nameTV)
       val itemDelete= view.findViewById<ImageView>(R.id.deleteItem)
//        val populationTV = view.findViewById<TextView>(R.id.yearTV)


    }



}
