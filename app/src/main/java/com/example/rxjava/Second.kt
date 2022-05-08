package com.example.rxjava

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.rxjava.databinding.SecondBinding
import io.reactivex.Observable
import io.reactivex.internal.operators.single.SingleInternalHelper.toObservable

class Second:AppCompatActivity() {

    lateinit var binding: SecondBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SecondBinding.inflate(layoutInflater)
        setContentView(binding.root)


        with(binding){
            btnWatch.setOnClickListener {
                startStreaming()
            }
        }

    }

    private fun startStreaming() {
        val numbers = Observable.range(1,6)

        val strings = Observable.just("one","two","three","four","five","six")

        val zipped = Observable.zip(strings, numbers){
                     s,n -> "$s$n"
        }
        zipped.subscribe(::println)



    }
}