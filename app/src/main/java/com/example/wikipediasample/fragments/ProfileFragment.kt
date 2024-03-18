package com.example.wikipediasample.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.wikipediasample.R
import com.example.wikipediasample.databinding.CardViewItemBinding
import com.example.wikipediasample.databinding.FragmentProfileBinding
import com.google.android.material.card.MaterialCardView

const val URL_WIKIPEDIA = "https://en.wikipedia.org/wiki/History_of_Wikipedia"

class ProfileFragment : Fragment() {

    private lateinit var binding: FragmentProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProfileBinding.inflate(layoutInflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.fabButtonProfileFragment.setOnClickListener {

            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(URL_WIKIPEDIA))
            startActivity(intent)
        }

    }
}