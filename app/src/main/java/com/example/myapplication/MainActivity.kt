package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.fahrenheitBtn.setOnClickListener(this)
        binding.celsiusBtn.setOnClickListener(this)
    }

    private fun fahren() {
        var deg = 0.0
        if (binding.tempEt.editText?.text.toString().isNotEmpty()) {
            deg = binding.tempEt.editText?.text.toString().toDouble()
        }
        var fer = (deg * 1.8) + 32
        binding.convertResultTv.text = fer.toString()
    }

    private fun celsius() {
        var deg = 0.0
        if (binding.tempEt.editText?.text.toString().isNotEmpty()) {
            deg = binding.tempEt.editText?.text.toString().toDouble()
        }
        var cel = (deg - 32) * 0.5556
        binding.convertResultTv.text = cel.toString()

    }

    override fun onClick(p0: View?) {
        if (p0 != null) {
            when (p0.id) {
                R.id.fahrenheitBtn -> {
                    fahren()
                }
                R.id.celsiusBtn -> {
                    celsius()
                }
            }
        }
    }
}