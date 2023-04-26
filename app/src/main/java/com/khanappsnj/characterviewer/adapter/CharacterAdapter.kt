package com.khanappsnj.characterviewer.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.khanappsnj.characterviewer.data.RelatedTopics
import com.khanappsnj.characterviewer.databinding.CharacterListItemBinding

class CharacterAdapter(private val characters: List<RelatedTopics>, val onRowClick: (RelatedTopics) -> Unit) :
    RecyclerView.Adapter<CharacterHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterHolder {
        val inflater = LayoutInflater.from(parent.context)

        return CharacterHolder(CharacterListItemBinding.inflate(inflater, parent, false))
    }

    override fun getItemCount(): Int {
        return characters.size
    }

    override fun onBindViewHolder(holder: CharacterHolder, position: Int) {
        holder.bind(characters[position], onRowClick)
    }
}