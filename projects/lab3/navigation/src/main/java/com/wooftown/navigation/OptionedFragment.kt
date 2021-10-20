package com.wooftown.navigation

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.viewbinding.ViewBinding
import com.wooftown.navigation.databinding.FragmentThirdBinding

abstract class OptionedFragment : Fragment() {
    protected var _binding: ViewBinding? = null

    protected val binding get() = _binding!!

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        _binding = FragmentThirdBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.options_menu, menu)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (item.itemId == R.id.about_item) {
            Navigation.findNavController(binding.root).navigate(R.id.global_about)
            true
        } else
            super.onOptionsItemSelected(item)
    }

}