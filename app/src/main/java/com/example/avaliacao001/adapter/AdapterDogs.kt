package com.example.avaliacao001.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.avaliacao001.R
import com.example.avaliacao001.model.DogsImages

class AdapterDogs : RecyclerView.Adapter<ItemDogViewHolder>() {

    private val listOfDogs = mutableListOf<DogsImages>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemDogViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_lista, parent, false)
        return ItemDogViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemDogViewHolder, position: Int) {
        listOfDogs[position].apply {
            holder.bind(this)
        }
    }

    override fun getItemCount(): Int {
        return listOfDogs.size
    }
}

class ItemDogViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(dog: DogsImages) {
        itemView.findViewById<ImageView>(R.id.imageViewDog).apply {
            Glide.with(context)
                .load(dog.mensagem)
                .placeholder(R.drawable.ic_launcher_background)
                .into(this)
        }
    }

}