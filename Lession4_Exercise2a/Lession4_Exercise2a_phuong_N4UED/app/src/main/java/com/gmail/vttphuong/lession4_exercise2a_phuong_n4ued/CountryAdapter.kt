package com.gmail.vttphuong.lession4_exercise2a_phuong_n4ued

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class CountryAdapter(val context: Context,val countrySource:List<CountryInfo>)
    :BaseAdapter() {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val rowView = LayoutInflater.from(context).inflate(
                R.layout.row_item_country, parent, false
        )
        rowView.findViewById<TextView>(R.id.nameTV).text = countrySource[position].name
        rowView.findViewById<TextView>(R.id.populationTV).text =
                countrySource[position].population.toString() + " millions"
        rowView.findViewById<ImageView>(R.id.flagIV).setImageResource(
                countrySource[position].flag
        )
        return rowView
    }

    override fun getItem(position: Int): Any {
        return countrySource[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return countrySource.count()
    }
}
