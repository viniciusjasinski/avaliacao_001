package com.example.avaliacao001.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {

    private val retrofitPhotos = Retrofit.Builder()
        .baseUrl("https://api.thedogapi.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getDogsPhotosService(): DogsPhotosService {
        return retrofitPhotos.create(DogsPhotosService::class.java)
    }

    private val retrofitCuriosity = Retrofit.Builder()
        .baseUrl("https://dog-facts-api.herokuapp.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getDogsCuriosityService(): DogsCuriosityService {
        return retrofitCuriosity.create(DogsCuriosityService::class.java)
    }

}