package com.gmail.nthoi.bai6_hoi_n4

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.gmail.nthoi.bai6_hoi_n4.R
import com.squareup.picasso.Picasso

class ArticleAdapter(val context: Context, val articleSource: ArrayList<ArticleInfo>):     RecyclerView.Adapter<ArticleAdapter.ViewHolder>(){
    var onItemClick: ((ArticleInfo) -> Unit)? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val rowView = LayoutInflater.from(context).inflate(R.layout.item_recycler_view,parent,false)
        return ViewHolder(rowView)
    }
    override fun getItemCount(): Int {
        return articleSource.size
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemText.text = articleSource[position].title
        Picasso.get().load(articleSource[position].imgURL)
            .into(holder.itemImg)
    }
    inner class ViewHolder(view: View):RecyclerView.ViewHolder(view){
        init{
            view.setOnClickListener{
                onItemClick?.invoke(articleSource[adapterPosition])
            }
        }
        val itemText = view.findViewById<TextView>(R.id.itemText)
        val itemImg = view.findViewById<ImageView>(R.id.itemImage)
    }
}