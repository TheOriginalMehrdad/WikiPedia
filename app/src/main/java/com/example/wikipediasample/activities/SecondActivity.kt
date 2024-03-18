package com.example.wikipediasample.activities

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.example.wikipediasample.data.ItemPost
import com.example.wikipediasample.databinding.ActivitySecondBinding
import com.example.wikipediasample.fragments.SEND_DATA_TO_SECOND_ACTIVITY

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


///====================================================================================================================================

        setSupportActionBar(binding.toolbar)
        binding.collapsing.setExpandedTitleColor(
            ContextCompat.getColor(this, android.R.color.transparent)
        )

        // To add home back button
        supportActionBar!!.setHomeButtonEnabled(true)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)



        val data = intent.getParcelableExtra<ItemPost>(SEND_DATA_TO_SECOND_ACTIVITY)

        if (data != null) {

            showData(data)
        }

    }

    private fun showData(itemPost: ItemPost) {

        Glide
            .with(this)
            .load(itemPost.urlImage)
            .into(binding.imageViewSecondActivity)

        binding.txTitleSecondActivity.text = itemPost.textTitle
        binding.txSubTitleSecondActivity.text = itemPost.textSubtitle
        binding.txtDescriptionSecondActivity.text = itemPost.textDescription
        binding.fabButtonSecondActivity.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(itemPost.textWebSite))
            startActivity(intent)
        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        // To the correct operation of the additional home button
        if (item.itemId == android.R.id.home) {
            onBackPressed()
        }

        return true
    }
}