package com.khanappsnj.characterviewer.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.khanappsnj.characterviewer.BuildConfig
import com.khanappsnj.characterviewer.data.Characters
import com.khanappsnj.characterviewer.data.RelatedTopics
import com.khanappsnj.characterviewer.network.RetrofitClient
import kotlinx.coroutines.launch

const val TAG = "CharacterViewModel"

class CharacterViewModel : ViewModel() {
    private val charactersRepository = MutableLiveData<List<RelatedTopics>>()

    private var _charactersTemp = MutableLiveData<List<RelatedTopics>>()
    val charactersTemp
        get() = _charactersTemp

    init {
        viewModelScope.launch {
            loadData()
        }
    }

    private suspend fun loadData() {
        val client = RetrofitClient.createInstance()
        try {
            val response = client.getCharacters(BuildConfig.QUERY, "json")
            if (response.isSuccessful) {
                charactersRepository.value = response.body()?.RelatedTopics
                charactersTemp.value = response.body()?.RelatedTopics
                Log.d(TAG, "Response came back successful ${response.body()}")
            } else {
                Log.d(TAG, "Response came back unsuccessful")
            }
        } catch (e: java.lang.Exception) {
            Log.d(TAG, "Response came back with and error : ${e.toString()}")
        }
    }

    fun onFiltered(searchText: String) {
        if (charactersRepository.value!!.any { it.Text!!.lowercase().contains(searchText) }) {
            charactersTemp.postValue(charactersRepository.value!!.filter {
                it.Text!!.lowercase().contains(searchText)
            })
        } else {
            charactersTemp.postValue(charactersRepository.value)
        }
    }
}