package com.khanappsnj.characterviewer.adapter

import androidx.recyclerview.widget.RecyclerView
import com.khanappsnj.characterviewer.data.RelatedTopics
import com.khanappsnj.characterviewer.databinding.CharacterListItemBinding

class CharacterHolder(val binding: CharacterListItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(relatedTopics: RelatedTopics, onRowClick: (RelatedTopics) -> Unit) {
        binding.apply {
            nameTextView.text = relatedTopics.Text?.substringBefore(" - ")?.trim()
            root.setOnClickListener{ onRowClick(relatedTopics) }
        }
    }

}