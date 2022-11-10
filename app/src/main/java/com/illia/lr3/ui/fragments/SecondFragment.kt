package com.illia.lr3.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.illia.lr3.R
import com.illia.lr3.databinding.FragmentSecondBinding

class SecondFragment : Fragment(){


    private var _binding: FragmentSecondBinding? = null

    private val binding get() = _binding!!

    val args: SecondFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        println("SecondFragment onCreateView")
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        val root: View = binding.root

//        binding.backButton.setOnClickListener{

//            val tx: FragmentTransaction = parentFragmentManager.beginTransaction()
//            tx.replace(this.id, FirstFragment()).addToBackStack("tag").commit()
//            supportFragmentManager.beginTransaction()
//                .replace(binding.fragment.id, ThirdFragment()) // place where to put fragment
//                .addToBackStack(null) // we want add fragment to backStack
//                .commit()
//        }

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        var text = "Humidity " + args.forecast.forecastAsString.trim() + " stands at " + args.forecast.humidity.toString()
        binding.textView.setText(text)
        Glide.with(view)
            .load(args.forecast.imageUrl)
            .centerCrop()
            .placeholder(binding.secondFragmentImagePlaceholder.drawable)
            .error(R.drawable.ic_launcher_foreground)
            .fallback(R.drawable.ic_launcher_foreground)
            .into(binding.secondFragmentImagePlaceholder)
        super.onViewCreated(view, savedInstanceState)
    }

}