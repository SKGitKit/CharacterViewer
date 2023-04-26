package com.khanappsnj.characterviewer.data

import com.google.gson.annotations.SerializedName


data class Characters(

    @SerializedName("RelatedTopics") var RelatedTopics: ArrayList<RelatedTopics> = arrayListOf()

)