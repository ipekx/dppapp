package com.example.digitalproductapp.model

/**
 * Data class representing a collection of items.
 *
 * @property name The name of the collection.
 * @property iconResId The resource ID of the icon associated with the collection.
 * @property items A list of items contained within the collection.
 * @property createdDate The timestamp when the collection was created, defaulting to current time.
 */
data class Collection(
    val name: String,
    val iconResId: Int,
    val items: List<String> = emptyList(),
    val createdDate: Long = System.currentTimeMillis()
)
