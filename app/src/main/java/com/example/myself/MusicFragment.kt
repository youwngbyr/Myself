package com.example.myself

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.widget.ImageView
import android.widget.TextView
// 09-06-2024
// Youwan Gebyar Zulnazri
// 10121253
class MusicFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: MusicAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_music, container, false)
        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(activity)

        // Buat daftar musik favorit
        val musicList = listOf(
            Music("if soulmates were songs", "Matthew Ilfield, Keshi , Slchld and more", "https://open.spotify.com/playlist/3J3ItBeSapqCZ6EmqAaJkO?si=54a5fc13fb3a453b", R.drawable.album1),
            Music("Froideur", "FKJ, JVKE, Yot Club and more", "https://open.spotify.com/playlist/5taTggsVkjHv1fO4Tq9aTM?si=f99c160ed48e4b6d", R.drawable.album2),
            Music("Who's Abel", "The weeknd", "https://open.spotify.com/playlist/3L2qhmt5iqUSWLSK6wm1qs?si=4722987467ba4f1b", R.drawable.album3)
        )

        adapter = MusicAdapter(musicList) { music ->
            // Mengatur listener untuk setiap item musik
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(music.link))
            startActivity(intent)
        }
        recyclerView.adapter = adapter

        return view
    }
}

data class Music(val title: String, val artist: String, val link: String, val imageResource: Int)

class MusicAdapter(private val musicList: List<Music>, private val onItemClick: (Music) -> Unit) :
    RecyclerView.Adapter<MusicViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MusicViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.music_item, parent, false)
        return MusicViewHolder(view)
    }

    override fun onBindViewHolder(holder: MusicViewHolder, position: Int) {
        val music = musicList[position]
        holder.bind(music)
        holder.itemView.setOnClickListener { onItemClick(music) }
    }

    override fun getItemCount(): Int {
        return musicList.size
    }
}

class MusicViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(music: Music) {
        itemView.findViewById<TextView>(R.id.txt_judul).text = music.title
        itemView.findViewById<ImageView>(R.id.albumImageView).setImageResource(music.imageResource)
    }
}
