package com.illia.lr3

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.illia.lr3.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    fun backLogic(v: View){
        onBackPressed()
    }
}