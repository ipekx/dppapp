package com.example.digitalproductapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.digitalproductapp.adapter.GridRecyclerViewAdapter
import com.example.digitalproductapp.viewmodel.CollectionsViewModel

class ProductsFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: GridRecyclerViewAdapter
    private lateinit var viewModel: CollectionsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_products, container, false)

        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)

        viewModel = ViewModelProvider(this).get(CollectionsViewModel::class.java)
        viewModel.collections.observe(viewLifecycleOwner, Observer { collections ->
            adapter = GridRecyclerViewAdapter(collections)
            recyclerView.adapter = adapter
        })

        return view
    }
}