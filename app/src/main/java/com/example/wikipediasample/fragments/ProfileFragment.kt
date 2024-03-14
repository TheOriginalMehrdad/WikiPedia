package com.example.wikipediasample.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.wikipediasample.R
import com.example.wikipediasample.databinding.CardViewItemBinding
import com.example.wikipediasample.databinding.FragmentProfileBinding
import com.google.android.material.card.MaterialCardView

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
        /*

                val binding2 = CardViewItemBinding.inflate(layoutInflater)
                binding2.mainCardView.isChecked = true


                val card = view.findViewById<MaterialCardView>(R.id.mainCardView)
                card.isChecked = true

                card.setOnClickListener {
                    card.isChecked = !card.isChecked
                }
        */


    }
}