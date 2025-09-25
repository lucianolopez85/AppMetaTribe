package com.metatribe.content.feed.ui.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.metatribe.content.feed.R
import com.metatribe.content.feed.databinding.FragmentHomeBinding
import com.metatribe.content.feed.ui.adapter.HomeAdapter
import com.metatribe.content.feed.ui.viewmodel.HomeViewModel

class HomeFragment : Fragment(R.layout.fragment_home) {

    private val binding by lazy { FragmentHomeBinding.bind(requireView()) }
    private val viewModel: HomeViewModel by viewModels()
    private lateinit var adapter: HomeAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as? AppCompatActivity)?.supportActionBar?.hide()

        setupObserver()
    }

    private fun setupRecyclerView() {
        adapter = HomeAdapter()
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = adapter
    }

    private fun setupObserver() {
        setupRecyclerView()
        viewModel.posts.observe(viewLifecycleOwner) { postList ->
            adapter.submitList(postList)
            binding.recyclerView.adapter = adapter
        }
        viewModel.fetchPosts()
    }

}




