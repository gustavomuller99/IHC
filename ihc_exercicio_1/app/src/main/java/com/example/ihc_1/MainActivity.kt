package com.example.ihc_1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doOnTextChanged
import com.example.ihc_1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var value1 = 0
    private var value2 = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.et1.doOnTextChanged { text, start, before, count ->
            value1 = if (text?.toString()?.isNotEmpty() == true) text.toString().toInt() else 0
        }

        binding.et2.doOnTextChanged { text, start, before, count ->
            value2 = if (text?.toString()?.isNotEmpty() == true) text.toString().toInt() else 0
        }

        binding.btnSum.setOnClickListener {
            binding.tvResult.text = "Result: ${value1 + value2}"
        }
    }
}