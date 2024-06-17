package com.example.digitalproductapp.repository

import com.example.digitalproductapp.R
import com.example.digitalproductapp.model.Collection

class CollectionRepository {

    private val collections : List<Collection> = listOf(
            Collection("History", R.drawable.history_icon),
            Collection("Favorites", R.drawable.favorites_icon),
            Collection("Cars", R.drawable.custom_collection_1_icon),
            Collection("Phones", R.drawable.custom_colection_2_icon)
        )


    fun getCollections(): List<Collection> {
        return collections
    }
}