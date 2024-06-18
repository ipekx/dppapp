package com.example.digitalproductapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.digitalproductapp.R
import android.widget.ImageView
import android.widget.TextView
import com.example.digitalproductapp.model.Collection

/**
 * Adapter class for displaying a list of `Collection` objects in a grid format
 * using a `RecyclerView`.
 *
 * @property collections The list of collections to be displayed.
 */
class GridRecyclerViewAdapter(private val collections: List<Collection>) :
    RecyclerView.Adapter<GridRecyclerViewAdapter.MyViewHolder>() {

    /**
     * This method is called when the `RecyclerView` needs a new `ViewHolder` of the given type to represent an item.
     *
     * @param parent The parent view that the view holder will be attached to.
     * @param viewType The view type of the new view.
     * @return A new `ViewHolder` that holds a view of the given view type.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        // Inflate the layout for the collection item view
        val view = LayoutInflater.from(parent.context).inflate(R.layout.collection_item, parent, false)
        return MyViewHolder(view)
    }

    /**
     * This method returns the total number of items in the data set held by the adapter.
     *
     * @return The total number of items in the adapter's data set.
     */
    override fun getItemCount(): Int {
        return collections.size
    }

    /**
     * This method is called by the `RecyclerView` to display the data at the specified position.
     * It updates the contents of the `ViewHolder` to reflect the item at the given position.
     *
     * @param holder The `ViewHolder` which should be updated to represent the contents of the item.
     * @param position The position of the item within the adapter's data set.
     */
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val collection = collections[position]
        // Bind the data to the view holder
        holder.bind(collection)
    }

    /**
     * ViewHolder class to hold and recycle views as they scroll off the screen.
     *
     * @property itemView The view representing an item in the `RecyclerView`.
     */
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // TextView for displaying the collection name
        private val collectionName: TextView = itemView.findViewById(R.id.collection_name)
        // ImageView for displaying the collection icon
        private val collectionIcon: ImageView = itemView.findViewById(R.id.collection_icon)

        /**
         * Binds the `Collection` data to the view.
         *
         * @param collection The collection object to be displayed.
         */
        fun bind(collection: Collection) {
            // Set the collection name
            collectionName.text = collection.name
            // Set the collection icon
            collectionIcon.setImageResource(collection.iconResId)
        }
    }
}