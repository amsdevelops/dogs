package com.example.dogs.presentation.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.dogs.R
import com.example.dogs.databinding.ActivityMainBinding
import com.example.dogs.presentation.viewmodel.MainActivityViewModel
import com.squareup.picasso.Picasso
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class MainActivity : AppCompatActivity() {

    private val viewModel by lazy {
        ViewModelProvider(this).get(MainActivityViewModel::class.java)
    }
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            viewModel.getDogFacts()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    {
                        Picasso.get()
                            .load(it.imageURL)
                            .into(binding.image)
                    },
                    { println("Error $it") }
                )
        }
    }
}