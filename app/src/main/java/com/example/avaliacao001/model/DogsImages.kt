package com.example.avaliacao001.model

import com.google.gson.annotations.SerializedName

data class DogsImages(

    @SerializedName("weight")
    val peso: Peso,
    @SerializedName("height")
    val altura: Altura,
    @SerializedName("id")
    val identificador: Int,
    @SerializedName("name")
    val nome: String,
    @SerializedName("bred_for")
    val criado: String,
    @SerializedName("breed_group")
    val grupo_raca: String,
    @SerializedName("life_span")
    val vida_media: String,
    @SerializedName("temperament")
    val temperamento: String,
    @SerializedName("origin")
    val origem: String,
    @SerializedName("reference_image_id")
    val referencia_id_imagem: String,
    @SerializedName("image")
    val imagem: Imagem,
)


data class Peso(
    @SerializedName("imperial")
    val imperial_peso: String,
    @SerializedName("metric")
    val metrica_peso: String

)

data class Altura(
    @SerializedName("imperial")
    val imperial_altura: String,
    @SerializedName("metric")
    val metrica_altura: String

)

data class Imagem(
    @SerializedName("id")
    val id_imagem: String,
    @SerializedName("width")
    val largura_imagem: Int,
    @SerializedName("height")
    val altura_imagem: Int,
    @SerializedName("url")
    val url: String,
)
