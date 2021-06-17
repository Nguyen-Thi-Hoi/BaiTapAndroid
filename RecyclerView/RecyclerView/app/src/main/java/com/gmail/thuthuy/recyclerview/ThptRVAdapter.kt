package com.gmail.thuthuy.recyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class ThptRVAdapter (val context: Context, val thptSource: List<ThptInfo>)
    :RecyclerView.Adapter<ThptRVAdapter.ViewHolder>(){

    val  listData: MutableList<ThptInfo> = thptSource as MutableList<ThptInfo>
    var onItemClick: ((ThptInfo) -> Unit)? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ThptRVAdapter.ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.row_item_thpt,
            parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.nameTV.text = thptSource[position].name
        holder.descriptionIV.setImageResource(thptSource[position].flag)
//        holder.locationTV.text = thptSource[position].location
        holder.itemDelete.setOnClickListener{
            val thptSource:List<ThptInfo>
            listData.removeAt(position)
            println(listData[0].name)
        }
    }

    override fun getItemCount(): Int {
        return thptSource.count()
    }
    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view)
    {
        val locationTV= view.findViewById<ImageView>(R.id.locationTV)
        val itemDelete= view.findViewById<ImageView>(R.id.deleteItem)
        val descriptionIV = view.findViewById<ImageView>(R.id.descriptionTV)
        val nameTV= view.findViewById<TextView>(R.id.nameTV)

        init {
            view.setOnClickListener {
                onItemClick?.invoke(thptSource[adapterPosition])
            }
        }

        }

    }
