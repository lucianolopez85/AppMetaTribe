package com.metatribe.content.feed.ui.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.metatribe.content.feed.R
import com.metatribe.content.feed.databinding.FragmentProfileBinding
import com.metatribe.content.feed.extension.medalList
import com.metatribe.content.feed.extension.metasDoAno
import com.metatribe.content.feed.ui.adapter.ProfileMedalAdapter
import com.metatribe.content.feed.ui.adapter.ProfileMetaAdapter

class ProfileFragment: Fragment(R.layout.fragment_profile) {

    private val binding by lazy { FragmentProfileBinding.bind(requireView()) }
    private lateinit var adapter: ProfileMetaAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity).supportActionBar?.hide()
        adapter = ProfileMetaAdapter(listOf()) {}
        setupMedal()
        setupMetas()

    }

    fun setupMetas() {

        binding.recyclerViewProfileMetaYear.layoutManager = LinearLayoutManager(requireContext())
        adapter = ProfileMetaAdapter(metasDoAno) { item->

        }
        binding.recyclerViewProfileMetaYear.adapter = adapter
    }

    fun setupMedal() {

        val adapter = ProfileMedalAdapter(medalList)
        binding.recyclerViewProfileMedals.adapter = adapter
        binding.recyclerViewProfileMedals.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

    }

}
