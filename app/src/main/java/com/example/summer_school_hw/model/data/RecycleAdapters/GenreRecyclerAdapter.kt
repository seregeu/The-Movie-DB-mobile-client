package com.example.summer_school_hw.model.data.RecycleAdapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.summer_school_hw.R
import com.example.summer_school_hw.model.data.dto.GenreDto
import com.example.summer_school_hw.model.data.room.entities.Genre
import jp.wasabeef.recyclerview.adapters.AlphaInAnimationAdapter

class GenreRecyclerAdapter(private val genres: List<Genre>,
                           private val listener: GenreRecyclerAdapter.OnGenreClickListener
):RecyclerView.Adapter<GenreRecyclerAdapter.MyViewHolder>() {

   inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),View.OnClickListener {
        var _TextView: TextView? = null
        init {
            _TextView = itemView.findViewById(R.id.genre_name)
            itemView.setOnClickListener(this)
        }

       override fun onClick(v: View?) {
           val posititon: Int = adapterPosition
           if (posititon!=RecyclerView.NO_POSITION) {
               listener.onGenreClick(posititon)
           }
       }
   }
    interface OnGenreClickListener{
        fun onGenreClick(position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.genre_list_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder._TextView?.text = genres[position].genreName
    }

    override fun getItemCount() = genres.size
}