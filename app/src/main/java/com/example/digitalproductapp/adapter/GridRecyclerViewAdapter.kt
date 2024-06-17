package com.example.digitalproductapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.digitalproductapp.R
import android.widget.ImageView
import android.widget.TextView
import com.example.digitalproductapp.model.Collection

class GridRecyclerViewAdapter(private val collections: List<Collection>) :
    RecyclerView.Adapter<GridRecyclerViewAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.collection_item, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return collections.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val collection = collections[position]
        holder.bind(collection)
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val collectionName: TextView = itemView.findViewById(R.id.collection_name)
        private val collectionIcon: ImageView = itemView.findViewById(R.id.collection_icon)

        fun bind(collection: Collection) {
            collectionName.text = collection.name
            collectionIcon.setImageResource(collection.iconResId)
        }
    }
}