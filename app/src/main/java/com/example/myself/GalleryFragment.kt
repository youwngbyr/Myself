package com.example.myself

import android.os.Bundle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
// 09-06-2024
// Youwan Gebyar Zulnazri
// 10121253
class GalleryFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_gallery, container, false)

        val galleryList = listOf(
            Gallery(R.drawable.img_sepeda, getString(R.string.txt_sepeda)),
            Gallery(R.drawable.img_komunitas, getString(R.string.txt_komunitas)),
            Gallery(R.drawable.img_mabar, getString(R.string.txt_wuwa)),
            Gallery(R.drawable.img_got, getString(R.string.txt_got)),
        )

        val recyclerView: RecyclerView = view.findViewById(R.id.recycler_view_grid)
        recyclerView.layoutManager = GridLayoutManager(context, 2)
        recyclerView.adapter = context?.let { GalleryAdapter(it, galleryList) }

        return view
    }
}