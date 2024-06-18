package com.example.digitalproductapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.digitalproductapp.model.Collection
import com.example.digitalproductapp.repository.CollectionRepository

/**
 * ViewModel responsible for managing collections data and interaction between UI and data repository.
 */
class CollectionsViewModel : ViewModel() {

    private val repository = CollectionRepository()

    // LiveData for collections to be observed by UI
    private val _collections = MutableLiveData<List<Collection>>()
    val collections: LiveData<List<Collection>> get() = _collections

    /**
     * Initializes ViewModel by loading collections from the repository.
     */
    init {
        loadCollections()
    }

    /**
     * Loads collections from the repository into the LiveData.
     */
    private fun loadCollections() {
        _collections.value = repository.getCollections()
    }

    /**
     * Updates collections LiveData with new collections data.
     *
     * @param newCollections The updated list of collections.
     */
    fun updateCollections(newCollections: List<Collection>) {
        _collections.value = newCollections
    }
}
