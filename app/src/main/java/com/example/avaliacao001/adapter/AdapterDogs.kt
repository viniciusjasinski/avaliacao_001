package com.example.avaliacao001.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.avaliacao001.R
import com.example.avaliacao001.model.DogsImages

class AdapterDogs(
    val clickDetalhes: ClickableItem
) : RecyclerView.Adapter<ItemDogViewHolder>() {

    private var listOfDogs : MutableList<DogsImages> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemDogViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.dog_item_list, parent, false)
        return ItemDogViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemDogViewHolder, position: Int) {
        listOfDogs[position].apply {
            holder.bind(this)
            holder.itemView.findViewById<Button>(R.id.buttonSelectDog).apply {
                setOnClickListener {
                    clickDetalhes.onClickItemCuriosidade()
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return listOfDogs.size
    }

    fun update(newList: List<DogsImages>) {
        listOfDogs = mutableListOf()
        listOfDogs.addAll(newList)
        notifyDataSetChanged()
    }

}

class ItemDogViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(dog: DogsImages) {
        itemView.findViewById<ImageView>(R.id.imageViewDog).apply {
            Glide.with(context)
                .load(dog.imagem.url)
                .placeholder(R.drawable.ic_launcher_background)
                .into(this)
        }
    }

}