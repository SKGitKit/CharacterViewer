package com.khanappsnj.characterviewer.data

import com.google.gson.annotations.SerializedName


data class RelatedTopics(

    @SerializedName("FirstURL") var FirstURL: String? = null,
    @SerializedName("Icon") var Icon: Icon? = Icon(),
    @SerializedName("Result") var Result: String? = null,
    @SerializedName("Text") var Text: String? = null

)