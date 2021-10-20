package com.wooftown.navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation
import com.wooftown.navigation.databinding.FragmentThirdBinding


class ThirdFragment : OptionedFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        _binding = FragmentThirdBinding.inflate(inflater, container, false)
        val view = binding.root
        view.findViewById<Button>(R.id.toFirst).setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_thirdFragment_to_firstFragment)
        }
        view.findViewById<Button>(R.id.toSecond).setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_thirdFragment_to_secondFragment)
        }
        return view
    }


}