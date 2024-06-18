package com.example.digitalproductapp.repository

import com.example.digitalproductapp.R
import com.example.digitalproductapp.model.Collection

/**
 * Repository class responsible for managing collections of items.
 */
class CollectionRepository {

    // Initial collections in the repository
    private val collections: MutableList<Collection> = mutableListOf(
        Collection("History", R.drawable.history_icon),
        Collection("Favorites", R.drawable.favorites_icon)
    )

    /**
     * Retrieves all collections currently stored in the repository.
     *
     * @return A list of all collections.
     */
    fun getCollections(): List<Collection> {
        return collections.toList()
    }

    /**
     * Adds a new collection to the repository if it doesn't already exist.
     *
     * @param collection The collection to add.
     */
    fun addCollection(collection: Collection) {
        if (collections.any { it.name == collection.name }) {
            println("Collection with name ${collection.name} already exists")
        } else {
            collections.add(collection)
        }
    }

    /**
     * Removes a collection from the repository.
     *
     * @param collection The collection to remove.
     */
    fun removeCollection(collection: Collection) {
        if (!collections.remove(collection)) {
            println("Collection ${collection.name} does not exist")
        }
    }
}
