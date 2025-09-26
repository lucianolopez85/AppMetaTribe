package com.metatribe.content.feed.ui.view

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.metatribe.content.feed.R
import com.metatribe.content.feed.databinding.FragmentCommunityBinding
import com.metatribe.content.feed.extension.mockData
import com.metatribe.content.feed.ui.adapter.CommunityAdapter

class CommunityFragment: Fragment(R.layout.fragment_community) {

    private val binding by lazy { FragmentCommunityBinding.bind(requireView()) }
    private lateinit var adapter: CommunityAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerViewCommunity.layoutManager = LinearLayoutManager(requireContext())

        adapter = CommunityAdapter(mockData) { item ->
            Toast.makeText(requireContext(), "Clicou em: ${item.title}", Toast.LENGTH_SHORT).show()
        }

        binding.recyclerViewCommunity.adapter = adapter
    }
}