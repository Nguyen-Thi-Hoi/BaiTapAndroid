package hoi.android.lession4bai2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import hoi.android.lession4bai2.R

class PlanetAdapter(val context: Context, val planetSource:List<PlanetInfo>)
    :BaseAdapter() {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val rowView = LayoutInflater.from(context).inflate(
            R.layout.row_item_planet,parent,false
        )
        rowView.findViewById<TextView>(R.id.nameTV).text = planetSource[position].name
        rowView.findViewById<TextView>(R.id.populationTV).text =
            planetSource[position].population.toString() + " AU"
        rowView.findViewById<ImageView>(R.id.planetVenus).setImageResource(
            planetSource[position].flag
        )
        return rowView
    }

    override fun getItem(position: Int): Any {
        return planetSource[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return planetSource.count()
    }

}