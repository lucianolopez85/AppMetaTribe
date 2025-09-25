package com.metatribe.content.feed.ui.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.metatribe.content.feed.R
import com.metatribe.content.feed.data.source.LocalDataSource
import com.metatribe.content.feed.databinding.FragmentProfileBinding
import com.metatribe.content.feed.extension.base64ToBitmap
import com.metatribe.content.feed.ui.adapter.ObjectiveAdapter

class ProfileFragment: Fragment(R.layout.fragment_profile) {

    private val binding by lazy { FragmentProfileBinding.bind(requireView()) }
    lateinit var localDataSource: LocalDataSource

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        localDataSource = LocalDataSource(requireContext())
        setupLayout()
    }

    private fun setupLayout() {
        val userVO = LocalDataSource(requireContext()).getPostsFromAssets()
        val objectives = userVO.ObjectiveVO

        binding.imgProfile.setImageBitmap(base64ToBitmap(userVO.userImage))
        binding.txtNameProfile.text = userVO.userName

        val adapter = ObjectiveAdapter(objectives)
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.adapter = adapter



    }
}