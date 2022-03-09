package com.example.pinterest.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pinterest.R
import com.example.pinterest.model.Photo


class FragmentOneAdapter(var context: Context, var items:ArrayList<Photo>):RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_home,parent,false)
        return HomeViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        val photo = items[position]
        if (holder is HomeViewHolder){
            val description = holder.description
            val image = holder.image
            description.text = photo.description


            Glide
                .with(context)
                .load(photo.urls.small)
                .into(image);



        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
    class HomeViewHolder(view: View):RecyclerView.ViewHolder(view){
        val description: TextView = view.findViewById(R.id.tv_text_home)
        val image: ImageView = view.findViewById<ImageView>(R.id.iv_pic_home)
    }
}