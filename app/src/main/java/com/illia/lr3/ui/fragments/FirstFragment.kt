package com.illia.lr3.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.illia.lr3.Forecast
import com.illia.lr3.ForecastAdapter
import com.illia.lr3.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    val adapter = ForecastAdapter() {pos ->
        findNavController().navigate(FirstFragmentDirections.firstToSecond(items[pos]))
    }

    private val binding get() = _binding!!
    val items = listOf(
        Forecast("for 2022-11-09 15:00:00\n", 15, "https://cdn.pixabay.com/photo/2012/04/23/15/17/number-38463_960_720.png"),
        Forecast("for 2022-11-09 18:00:00\n", 18, "https://st2.depositphotos.com/1020917/6286/i/950/depositphotos_62866705-stock-photo-the-number-18.jpg"),
        Forecast("for 2022-11-09 21:00:00\n", 21, null),
        Forecast("for 2022-11-10 00:00:00\n", 0, null),
        Forecast("for 2022-11-10 03:00:00\n", 3, null),
        Forecast("for 2022-11-10 06:00:00\n", 6, null),
        Forecast("for 2022-11-10 09:00:00\n", 9, null),
        Forecast("for 2022-11-10 12:00:00\n", 12, null)
    )

    override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
    ): View
    {

        println("FirstFragment onCreateView")
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        println("FirstFragment onViewCreated id ")

        binding.recyclerView.adapter = adapter

        binding.button.setOnClickListener {
            adapter.setList(items)

        }
        super.onViewCreated(view, savedInstanceState)
    }

}