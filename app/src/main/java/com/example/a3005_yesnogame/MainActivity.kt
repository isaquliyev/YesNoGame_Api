package com.example.a3005_yesnogame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.a3005_yesnogame.databinding.ActivityMainBinding
import com.example.a3005_yesnogame.viewmodel.ResultViewModel



class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    lateinit var viewModel : ResultViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        pressButton()
        viewModel = ViewModelProvider(this)[ResultViewModel::class.java]
        viewModel.getResult()
        viewModel.observeAnswerLiveData().observe(this,
            Observer {answer ->
                if (answer.answer != binding.editTextText.text.toString()) {
                    setGif(answer.image)
                    binding.textView2.setText("")
                }
                else {
                    binding.textView2.setText("You Won!")
                    binding.imageView.setImageResource(0)
                }
            }
            )
    }

    fun pressButton() {
        binding.button.setOnClickListener {
            viewModel.getResult()
        }
    }

    fun setGif( url : String) {
        Glide.with(this).load(url).into(binding.imageView)
    }

}