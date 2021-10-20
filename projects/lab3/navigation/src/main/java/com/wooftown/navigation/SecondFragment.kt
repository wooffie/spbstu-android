package com.wooftown.navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation
import com.wooftown.navigation.databinding.FragmentSecondBinding


class SecondFragment : OptionedFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        val view = binding.root
        view.findViewById<Button>(R.id.toFirst).setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_secondFragment_to_firstFragment)
        }
        view.findViewById<Button>(R.id.toThird).setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_secondFragment_to_thirdFragment)
        }

        return view
    }


}