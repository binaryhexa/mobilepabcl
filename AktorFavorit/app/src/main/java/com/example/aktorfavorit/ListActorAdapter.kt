package com.example.aktorfavorit

import android.app.DownloadManager.Request
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.aktorfavorit.databinding.ActivityMainBinding
import com.example.aktorfavorit.databinding.ItemRowAktorBinding

class ListActorAdapter(private val list : ArrayList<Actors>) :
    RecyclerView.Adapter<ListActorAdapter.ListViewHolder>() {

    inner class ListViewHolder(private val binding: ItemRowAktorBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(actors: Actors){
            with(binding){
                tvActorName.text = actors.name
                tvDetailActor.text = actors.detail
                Glide.with(itemView.context)
                    .load(actors.photo)
                    .apply(RequestOptions().override(260,260))
                    .into(avActor)
                itemView.setOnClickListener{
                    val intent = Intent(itemView.context, DetailActivity::class.java)
                    intent.putExtra(DetailActivity.EXTRA_DETAIL, actors)
                    itemView.context.startActivity(intent)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ItemRowAktorBinding.inflate((LayoutInflater.from(parent.context)), parent, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val data = list[position]

        holder.bind(data)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}