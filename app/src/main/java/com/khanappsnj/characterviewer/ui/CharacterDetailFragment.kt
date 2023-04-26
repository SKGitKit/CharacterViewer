package com.khanappsnj.characterviewer.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.khanappsnj.characterviewer.databinding.CharacterDetailBinding

class CharacterDetailFragment : Fragment() {

    private val args: CharacterDetailFragmentArgs by navArgs()
    private var _binding: CharacterDetailBinding? = null
    private val binding
        get() = checkNotNull(_binding) {
            "Is the view visible?"
        }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = CharacterDetailBinding.inflate(inflater, container, false)
        return (binding.root)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bundle = arguments

        if (!bundle!!.containsKey("charName")) {
            binding.apply {
                if (args.charImage.isNotEmpty()) {
                    Glide.with(requireActivity())
                        .load("https://duckduckgo.com/${args.charImage}")
                        .into(characterImageView)
                }
                titleTextView.text = args.charName
                descriptionTextView.text = args.charDescription
            }
        } else {
            binding.apply {
                Glide.with(requireActivity())
                    .load("https://duckduckgo.com/${bundle?.getString("charImage")}")
                    .into(characterImageView)
                titleTextView.text = bundle.getString("charName")
                descriptionTextView.text = bundle.getString("charDescription")
            }
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}