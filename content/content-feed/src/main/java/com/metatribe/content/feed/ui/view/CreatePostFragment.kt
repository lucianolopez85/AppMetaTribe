package com.metatribe.content.feed.ui.view

import android.app.Dialog
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import com.metatribe.content.feed.R
import com.metatribe.content.feed.databinding.FragmentCreatePostBinding
import com.metatribe.content.feed.extension.bitmapToBase64
import com.metatribe.content.feed.extension.getBitmapFromUri
import com.metatribe.content.feed.extension.mockDataUser
import com.metatribe.content.feed.ui.viewmodel.CreatePostViewModel

class CreatePostFragment : DialogFragment() {

    private val viewModel: CreatePostViewModel by viewModels()

    companion object {
        private const val ARG_IMAGE_URI = "image_uri"

        fun newInstance(imageUri: String): CreatePostFragment {
            val fragment = CreatePostFragment()
            val args = Bundle()
            args.putString(ARG_IMAGE_URI, imageUri)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(requireContext())
        val inflater = requireActivity().layoutInflater
        val view = inflater.inflate(R.layout.fragment_create_post, null)
        val binding = FragmentCreatePostBinding.bind(view)

        val imageUri = arguments?.getString(ARG_IMAGE_URI)
        imageUri?.let {
            binding.selectedImageView.setImageURI(Uri.parse(it))
        }

        builder.setView(view)
            .setTitle("Adicionar publicação")
            .setNegativeButton("Cancelar") { dialog, _ -> dialog.dismiss() }
            .setPositiveButton("Publicar") { _, _ ->
                val caption = binding.captionEditText.text.toString()
                val imageBitmap = getBitmapFromUri(requireContext(), Uri.parse(imageUri))
                val imageBase64 = bitmapToBase64(imageBitmap)
                viewModel.saveNewPost(imageBase64, caption, mockDataUser)
            }

        return builder.create()
    }
}
