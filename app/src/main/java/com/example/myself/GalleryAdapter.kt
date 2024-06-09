package com.example.myself

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
// 09-06-2024
// Youwan Gebyar Zulnazri
// 10121253
class GalleryAdapter(private val context: Context, private val galleryList: List<Gallery>) : RecyclerView.Adapter<GalleryAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
        val titleText: TextView = itemView.findViewById(R.id.tittle_text)
        val cardView: View = itemView.findViewById(R.id.cardView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.grid_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = galleryList[position]
        holder.imageView.setImageResource(currentItem.imageResId)
        holder.titleText.text = currentItem.title

        // Set onClickListener for the cardView
        holder.cardView.setOnClickListener {
            // Display a Toast message with the title of the clicked item
            Toast.makeText(context, currentItem.title, Toast.LENGTH_LONG).show()
        }
    }

    override fun getItemCount(): Int {
        return galleryList.size
    }
}