package com.metatribe.account.login.ui.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.metatribe.account.login.R
import com.metatribe.account.login.databinding.FragmentLoginBinding
import com.project.router.IntentUtils

class LoginFragment : Fragment(R.layout.fragment_login){

    private val binding by lazy { FragmentLoginBinding.bind(requireView()) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnEntrar.setOnClickListener {
            startActivity(IntentUtils.createFeedIntent(requireContext()))
        }

        binding.tvCadastrar.setOnClickListener {
        }
    }
}