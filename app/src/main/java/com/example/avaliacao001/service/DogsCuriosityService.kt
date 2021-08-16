package com.example.avaliacao001.service

import com.example.avaliacao001.model.DogsCuriosity
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface DogsCuriosityService {

    @GET("/api/v1/resources/dogs")
    fun getCuriosity(@Query("index") id_fact: Int?): Call<List<DogsCuriosity>>

}