package com.example.digitalproductapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.digitalproductapp.adapter.GridRecyclerViewAdapter
import com.example.digitalproductapp.model.Collection
import com.example.digitalproductapp.repository.CollectionRepository
import com.example.digitalproductapp.viewmodel.CollectionsViewModel

/**
 * A Fragment responsible for displaying collections in a grid format.
 */
class CollectionsFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: GridRecyclerViewAdapter
    private lateinit var viewModel: CollectionsViewModel
    private val repository = CollectionRepository()

    /**
     * Called to have the fragment instantiate its user interface view.
     *
     * @param inflater The LayoutInflater object that can be used to inflate
     * any views in the fragment.
     * @param container If non-null, this is the parent view that the fragment's
     * UI should be attached to. The fragment should not add the view itself,
     * but this can be used to generate the LayoutParams of the view.
     * @param savedInstanceState If non-null, this fragment is being re-constructed
     * from a previous saved state as given here.
     * @return Return the View for the fragment's UI, or null.
     */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_collections, container, false)

        // Initialize RecyclerView and set up GridLayoutManager
        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)

        // Initialize ViewModel using ViewModelProvider
        viewModel = ViewModelProvider(this)[CollectionsViewModel::class.java]

        // Observe changes in collections LiveData
        viewModel.collections.observe(viewLifecycleOwner) { collections ->
            // Update RecyclerView adapter with new collections
            adapter = GridRecyclerViewAdapter(collections)
            recyclerView.adapter = adapter
        }

        // Initialize default collections on fragment creation
        initializeDefaultCollections()

        return view
    }

    /**
     * Initializes default collections in the repository and updates ViewModel.
     */
    private fun initializeDefaultCollections() {
        // Add default collections to the repository
        repository.addCollection(Collection("Cars", R.drawable.car_icon))
        repository.addCollection(Collection("Phones", R.drawable.phone_icon))

        // Notify the ViewModel or update LiveData with the new collections
        viewModel.updateCollections(repository.getCollections())
    }
}
