package com.example.avaliacao001.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.avaliacao001.R
import com.example.avaliacao001.adapter.AdapterDogs
import com.example.avaliacao001.model.DogsCuriosity
import com.example.avaliacao001.service.RetrofitBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetalhesFragment : Fragment(R.layout.fragment_detalhes), Callback<DogsCuriosity> {

    private lateinit var fatoAleatorio: TextView

    val call by lazy {
        val service = RetrofitBuilder.getDogsCuriosityService()
        service.getCuriosity((0..434).random())
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        call.clone().enqueue(this)
        fatoAleatorio = view.findViewById(R.id.textViewCuriosity)
    }

    override fun onResponse(call: Call<DogsCuriosity>, response: Response<DogsCuriosity>) {
        response.body()?.apply {
            bind(this)
        }
    }

    override fun onFailure(call: Call<DogsCuriosity>, t: Throwable) {
        println("Falhou")
    }

    fun bind(dogsCuriosity: DogsCuriosity) {

        fatoAleatorio.text = dogsCuriosity.fato

    }


}