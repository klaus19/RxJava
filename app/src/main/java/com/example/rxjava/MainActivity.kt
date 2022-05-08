package com.example.rxjava

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.rxjava.databinding.ActivityMainBinding
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    val TAG = "Main"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.button.setOnClickListener {

            startRstream()
        }

        binding.btn2.setOnClickListener {
                startActivity(Intent(this@MainActivity, Second::class.java))
        }
    }

    private fun startRstream() {
        //Create an OBservable

        val myObservable = getObservable()

        //Create an Observer 
        val observer = getObserver()

        //Subscribe my Observer to Observable
        myObservable
            .subscribe(observer)
    }

    private fun getObserver(): Observer<String> {

        return object : Observer<String> {
            override fun onSubscribe(d: Disposable) {

            }
            //Every time onNext is called, print the value to Android Studio’s Logcat//


            override fun onError(e: Throwable) {
                Log.e(TAG, "onError: " + e.message)
            }

            override fun onNext(t: String) {
                var s = ""
                Log.d(TAG, "onNext: $s")

            }

            override fun onComplete() {
                Log.d(TAG, "onComplete")
            }

        }

    }

    private fun getObservable(): Observable<String> {

        return Observable.just("1","2","3","4","5")
    }
}