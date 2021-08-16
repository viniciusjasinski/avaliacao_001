package com.example.avaliacao001.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.example.avaliacao001.DetalhesActivity
import com.example.avaliacao001.R
import com.example.avaliacao001.model.DogsCuriosity
import com.example.avaliacao001.service.RetrofitBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetalhesFragment : Fragment(R.layout.fragment_detalhes), Callback<List<DogsCuriosity>> {

    private lateinit var aleatoryFact: TextView
    private lateinit var backButton: Button

    val call by lazy {
        RetrofitBuilder.getDogsCuriosityService().getCuriosity((0..434).random())
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loadComponents(view)
        call.clone().enqueue(this)
    }

    private fun loadComponents(view: View) {
        aleatoryFact = view.findViewById(R.id.textViewCuriosity)
    }

    fun bind(dogsCuriosity: DogsCuriosity) {
        aleatoryFact.text = dogsCuriosity.fato
    }

    override fun onResponse(call: Call<List<DogsCuriosity>>, response: Response<List<DogsCuriosity>>) {
        response.body()?.apply {
            bind(this[0])
        }
    }

    override fun onFailure(call: Call<List<DogsCuriosity>>, t: Throwable) {
        println("Falhou")
    }




}