package com.example.digitalproductapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.digitalproductapp.model.Collection
import com.example.digitalproductapp.repository.CollectionRepository

class CollectionsViewModel : ViewModel() {

    private val repository = CollectionRepository()

    private val _collections = MutableLiveData<List<Collection>>()
    val collections: LiveData<List<Collection>> get() = _collections

    init {
        loadCollections()
    }

    private fun loadCollections() {
        _collections.value = repository.getCollections()
    }
}