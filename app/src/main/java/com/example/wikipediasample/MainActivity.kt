package com.example.wikipediasample

import android.os.Bundle
import android.widget.Toast

import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.wikipediasample.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        setSupportActionBar(binding.mainToolBar)


        val actionBarDrawerToggle = ActionBarDrawerToggle(

            this,
            binding.mainDrawerLayout,
            binding.mainToolBar,
            R.string.openDrawer,
            R.string.closeDrawer
        )
        binding.mainDrawerLayout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()

        binding.mainNavigationView.setNavigationItemSelectedListener {

            when (it.itemId) {

                R.id.menu_writer -> {

                    Toast.makeText(this, "Writer", Toast.LENGTH_SHORT).show()
                    binding.mainDrawerLayout.closeDrawer(GravityCompat.START)
                }

                R.id.menu_photograph -> {

                    Toast.makeText(this, "Photographer", Toast.LENGTH_SHORT).show()
                    binding.mainDrawerLayout.closeDrawer(GravityCompat.START)

                }

                R.id.menu_videoProducer -> {

                    Toast.makeText(this, "Video Producer", Toast.LENGTH_SHORT).show()
                    binding.mainDrawerLayout.closeDrawer(GravityCompat.START)

                }

                R.id.menu_translator -> {

                    Toast.makeText(this, "Translator", Toast.LENGTH_SHORT).show()
                    binding.mainDrawerLayout.closeDrawer(GravityCompat.START)

                }

                R.id.menu_open_wikipedia -> {}
                R.id.menu_open_wikimedia -> {}
            }

            true
        }

    }
}