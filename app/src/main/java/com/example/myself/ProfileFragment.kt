package com.example.myself

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
// 09-06-2024
// Youwan Gebyar Zulnazri
// 10121253
class ProfileFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_profile, container, false)

        // Set OnClickListener for Instagram TextView
        val txtIg: TextView = view.findViewById(R.id.txt_clik_ig)
        txtIg.setOnClickListener {
            val instagramUrl = "https://www.instagram.com/wildanprmn__?igshid=MWQ1OTdwZ21wdDdmNg=="
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(instagramUrl))
            if (intent.resolveActivity(requireActivity().packageManager) != null) {
                startActivity(intent)
            } else {
                Toast.makeText(requireContext(), "No application can handle this request. Please install a web browser or the Instagram app.", Toast.LENGTH_LONG).show()
            }
        }

        // Set OnClickListener for Find Me Button
        val btnFindMe: Button = view.findViewById(R.id.btn_find_me)
        btnFindMe.setOnClickListener {
            val address = "7°04'47.5\"S 107°33'58.4\"E" // Replace with the actual address
            val gmmIntentUri = Uri.parse("geo:0,0?q=${Uri.encode(address)}")
            val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
            mapIntent.setPackage("com.google.android.apps.maps")
            if (mapIntent.resolveActivity(requireActivity().packageManager) != null) {
                startActivity(mapIntent)
            } else {
                Toast.makeText(requireContext(), "No application can handle this request. Please install Google Maps.", Toast.LENGTH_LONG).show()
            }
        }

        return view
    }
}
