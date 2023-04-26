package com.khanappsnj.characterviewer.ui

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.widget.SearchView
import androidx.core.content.ContextCompat.getSystemService
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.khanappsnj.characterviewer.R
import com.khanappsnj.characterviewer.adapter.CharacterAdapter
import com.khanappsnj.characterviewer.databinding.CharactersListBinding
import com.khanappsnj.characterviewer.viewmodel.CharacterViewModel

class CharacterFragment : Fragment() {

    private val characterViewModel: CharacterViewModel by viewModels()
    private var _binding: CharactersListBinding? = null
    private var detailContainer: View? = null
    private val binding
        get() = checkNotNull(_binding) {
            "Is the view visible?"
        }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = CharactersListBinding.inflate(inflater, container, false)
        detailContainer = binding.detailfrag
        return (binding.root)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        characterViewModel.charactersTemp.observe(requireActivity()) {
            Log.d("fragment", "${it.size}")
            binding.apply {
                characterRecyclerView.apply {
                    adapter = CharacterAdapter(it) { character ->

                        if (detailContainer != null) {
                            val bundle = Bundle().apply {
                                putString("charImage", character.Icon?.URL!!)
                                putString(
                                    "charName",
                                    character.Text?.substringBefore(" - ")!!.trim()
                                )
                                putString(
                                    "charDescription",
                                    character.Text?.substringAfter(" - ")!!
                                )
                            }
                            val detailFragment = CharacterDetailFragment()
                            detailFragment.arguments = bundle
                            requireActivity().supportFragmentManager.popBackStack(
                                null,
                                FragmentManager.POP_BACK_STACK_INCLUSIVE
                            )
                            requireActivity().supportFragmentManager.beginTransaction()
                                .add(R.id.detailfrag, detailFragment)
                                .addToBackStack(null)
                                .commit()
                        } else {
                            findNavController().navigate(
                                CharacterFragmentDirections.goToDetail(
                                    charImage = character.Icon?.URL!!,
                                    charName = character.Text?.substringBefore(" - ")!!.trim(),
                                    charDescription = character.Text?.substringAfter(" - ")!!
                                )
                            )
                        }
                    }
                }
                characterSearchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                    override fun onQueryTextSubmit(query: String?): Boolean {
                        characterSearchView.clearFocus()
                        return true
                    }

                    override fun onQueryTextChange(newText: String?): Boolean {
                        characterViewModel.onFiltered(newText as String)
                        return true
                    }

                })
            }
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}