package com.example.avaliacao001.service

import com.example.avaliacao001.model.DogsImages
import retrofit2.Call
import retrofit2.http.GET

interface DogsPhotosService {

    @GET("/v1/breeds")
    fun getAllPhotos(): Call<List<DogsImages>>

}