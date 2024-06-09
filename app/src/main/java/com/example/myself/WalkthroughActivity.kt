package com.example.myself

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
// 09-06-2024
// Youwan Gebyar Zulnazri
// 10121253
class WalkthroughActivity : AppCompatActivity(), View.OnClickListener {

    private var currentPage = 0 // Track the current page index
    private lateinit var viewPager: ViewGroup // Container for walkthrough pages
    private lateinit var btnNext: Button // Button to navigate to next page or finish

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_walkthrough)

        // Initialize views
        viewPager = findViewById(R.id.viewPager)
        btnNext = findViewById(R.id.btnNext)

        // Set click listener for next button
        btnNext.setOnClickListener(this)

        // Set initial page content
        setPageContent(currentPage)
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.btnNext -> {
                if (currentPage < 2) { // Assuming 3 pages, change if needed
                    currentPage++

                    // Terapkan animasi slide saat menghapus halaman saat ini
                    val animation = AnimationUtils.loadAnimation(this, R.anim.slide_left)
                    viewPager.getChildAt(0)?.startAnimation(animation)

                    // Atur delay untuk menunggu animasi selesai sebelum menambahkan halaman baru
                    Handler().postDelayed({
                        setPageContent(currentPage)
                    }, animation.duration)
                } else {
                    // Simpan status bahwa walkthrough sudah selesai ditampilkan
                    val sharedPreferences = getSharedPreferences("app_prefs", Context.MODE_PRIVATE)
                    sharedPreferences.edit().putBoolean("isFirstRun", false).apply()

                    // Navigate to main activity when walkthrough finished
                    startActivity(Intent(this, MainActivity::class.java))
                    finish()
                }
            }
        }
    }

    private fun setPageContent(pageIndex: Int) {
        viewPager.removeAllViews() // Remove existing views

        // Inflate layout for the current page
        val layoutResId = when (pageIndex) {
            0 -> R.layout.page_1
            1 -> R.layout.page_2
            else -> R.layout.page_3
        }
        val view = LayoutInflater.from(this).inflate(layoutResId, viewPager, false)

        // Terapkan animasi slide saat menambahkan halaman baru
        val animation = AnimationUtils.loadAnimation(this, R.anim.slide_right)
        view.startAnimation(animation)

        viewPager.addView(view)
    }
}