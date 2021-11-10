package com.wooftown.navigation

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment

import androidx.navigation.fragment.findNavController


class Fragment1 : BasedFragment(R.layout.fragment1)
class Fragment2 : BasedFragment(R.layout.fragment2)
class Fragment3 : BasedFragment(R.layout.fragment3)

abstract class BasedFragment(private val res: Int) : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val layout = inflater.inflate(res, container, false)

        layout.findViewById<View>(R.id.bnToFirst)?.setOnClickListener {
            findNavController().navigate(R.id.action_to1)
        }

        layout.findViewById<View>(R.id.bnToSecond)?.setOnClickListener {
            findNavController().navigate(R.id.action_to2)
        }

        layout.findViewById<View>(R.id.bnToThird)?.setOnClickListener {
            findNavController().navigate(R.id.action_to3)
        }

        return layout
    }

}