package com.logituit.mvvm.viewmodel


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.logituit.mvvm.R
import com.logituit.mvvm.models.Result

class Myadapter(val context: Context, val MoviesList: List<Result>) :
    RecyclerView.Adapter<Myadapter.MoviesViewHolder>() {
    class MoviesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val poster: ImageView = itemView.findViewById(R.id.image)
        val name: TextView = itemView.findViewById(R.id.text)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val view =
            LayoutInflater.from(context).inflate(R.layout.item_view, parent, false)
        return MoviesViewHolder(view)
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        val movies = MoviesList[position]
        holder.name.text=movies.title
        Glide.with(context).load("https://image.tmdb.org/t/p/w500"+movies.poster_path).into(holder.poster)

    }

    override fun getItemCount(): Int {
        return MoviesList.size
    }


}
