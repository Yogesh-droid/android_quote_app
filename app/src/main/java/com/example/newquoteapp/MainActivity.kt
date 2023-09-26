package com.example.newquoteapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    private lateinit var mainViewModel : MainViewModel
    private lateinit var quoteTextView: TextView
    private lateinit var authorTextView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel = ViewModelProvider(this,MainViewModelFactory(application))[MainViewModel::class.java]
        quoteTextView = findViewById(R.id.quote_text)
        authorTextView = findViewById(R.id.quote_author)

        quoteTextView.text = mainViewModel.getQuote()[mainViewModel.index].text
        authorTextView.text = mainViewModel.getQuote()[mainViewModel.index].author
    }

    fun onPreviousTapped(view: View) {
        val previousQuote =  mainViewModel.previousQuote()
        if (previousQuote != null) {
            Log.d("onClick",previousQuote.text)
            quoteTextView.text = previousQuote.text
            authorTextView.text = previousQuote.author
        }else{
            Log.d("onClick","null")
        }


    }
    fun onNextTapped(view: View) {
        val nextQuote = mainViewModel.nextQuote()
        if (nextQuote != null) {
            Log.d("onClick",nextQuote.text)
            quoteTextView.text = nextQuote.text
            authorTextView.text = nextQuote.author
        }else{
            Log.d("onClick","null")
        }


    }
}