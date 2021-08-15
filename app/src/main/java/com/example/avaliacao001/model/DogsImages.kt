package com.example.avaliacao001.model

import com.google.gson.annotations.SerializedName

data class DogsImages(

    @SerializedName("message")
    val mensagem: String,
    @SerializedName("status")
    val status: String

)

