package com.example.avaliacao001.ui.main

import android.content.Context
import android.media.Image
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.avaliacao001.R
import com.example.avaliacao001.model.DogsCuriosity
import com.example.avaliacao001.model.DogsImages
import com.example.avaliacao001.service.RetrofitBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetalhesFragment : Fragment(R.layout.fragment_detalhes), Callback<List<DogsCuriosity>> {

    private lateinit var aleatoryFact: TextView
    private lateinit var imageFromDog: ImageView
    private lateinit var dogsImage: String

    val call by lazy {
        RetrofitBuilder.getDogsCuriosityService().getCuriosity((0..434).random())
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        arguments?.getString("passDogsImages")?.let {
            dogsImage = it
        }
    }

    companion object {
        fun newInstance(dogsImages: String) : DetalhesFragment {
            return DetalhesFragment().apply {
                arguments = Bundle().apply {
                    putString("passDogsImages", dogsImages)
                }
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loadComponents(view)
        call.clone().enqueue(this)
    }

    private fun loadComponents(view: View) {
        aleatoryFact = view.findViewById(R.id.textViewCuriosity)
        imageFromDog = view.findViewById(R.id.imageViewDogCuriosity)
    }

    fun bind(dogsCuriosity: DogsCuriosity) {
        aleatoryFact.text = dogsCuriosity.fato
        imageFromDog.apply {
            Glide.with(context)
                .load(dogsImage)
                .placeholder(R.drawable.ic_baseline_mood_bad_24)
                .into(this)
        }
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