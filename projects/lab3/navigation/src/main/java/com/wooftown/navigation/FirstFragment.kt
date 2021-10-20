package com.wooftown.navigation

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Button
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.viewbinding.ViewBinding
import com.wooftown.navigation.databinding.FragmentFirstBinding

class FirstFragment : OptionedFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        setHasOptionsMenu(true)
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        val view = binding.root
        view.findViewById<Button>(R.id.toSecond).setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_firstFragment_to_secondFragment)
        }
        return view
    }


}