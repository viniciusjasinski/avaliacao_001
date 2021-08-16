package com.example.avaliacao001.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.avaliacao001.MainActivity
import com.example.avaliacao001.R
import com.example.avaliacao001.adapter.AdapterDogs
import com.example.avaliacao001.adapter.ClickableItem
import com.example.avaliacao001.model.DogsImages
import com.example.avaliacao001.service.RetrofitBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainFragment : Fragment(R.layout.main_fragment), Callback<List<DogsImages>>, ClickableItem {

    lateinit var adapter : AdapterDogs
    lateinit var recyclerView: RecyclerView

    val call by lazy {
        val service = RetrofitBuilder.getDogsPhotosService()
        service.getAllPhotos()
    }

    companion object {
        fun newInstance() = MainFragment()
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        geraLista(view)
        call.clone().enqueue(this)

    }

    private fun geraLista(view: View) {
        adapter = AdapterDogs(this)
        recyclerView = view.findViewById(R.id.recyclerViewDogs)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter
    }

    override fun onResponse(
        call: Call<List<DogsImages>>,
        response: Response<List<DogsImages>>
    ) {
        response.body()?.apply {
            adapter.update(this)
        }
    }

    override fun onFailure(call: Call<List<DogsImages>>, t: Throwable) {
        println("Falhou")
    }

    override fun onClickItemCuriosidade() {
        (requireActivity() as? MainActivity)?.activityDetalhes()
    }


}