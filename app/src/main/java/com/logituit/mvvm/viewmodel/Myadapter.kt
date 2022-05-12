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
import com.logituit.mvvm.models.QuoteList
import com.logituit.mvvm.models.Result
import okhttp3.internal.Internal.instance
import org.jetbrains.annotations.NotNull

class Myadapter(val context: Context,val movie:ArrayList<QuoteList>): RecyclerView.Adapter<Myadapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater: LayoutInflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_view, parent, false)
        return MyViewHolder(view)
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        // val IMAGE_BASE="https://image.tmdb.org/t/p/w500/"
        val currentItem=movie[position]
        holder.title.text=currentItem.results.toString()
        holder.title.text=currentItem.page.toString()
        holder.title.text=currentItem.total_pages.toString()
        holder.title.text=currentItem.total_results.toString()

        Glide.with(holder.image)
            .load("https://image.tmdb.org/t/p/w500/"+currentItem.results)
            .into(holder.image)
        }

    override fun getItemCount(): Int {
        return movie.size
    }
class MyViewHolder(@NotNull itemView: View) : RecyclerView.ViewHolder(itemView) {
        var title = itemView.findViewById<TextView>(R.id.text)
        var image=itemView.findViewById<ImageView>(R.id.image)
    }
}
