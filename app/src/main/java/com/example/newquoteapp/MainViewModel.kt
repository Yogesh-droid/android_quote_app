package com.example.newquoteapp

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.google.gson.Gson

class MainViewModel(application: Application) : AndroidViewModel(application) {
    private var quoteList: Array<Quotes> = emptyArray()
    var index = 0
    init {
        val inputStream = application.applicationContext.assets.open("quotes.json")
        val size = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val json = String(buffer, Charsets.UTF_8)
        val gson = Gson()
        quoteList = gson.fromJson(json,Array<Quotes>::class.java)
    }

    fun getQuote():Array<Quotes>{
        return quoteList;
    }

    fun nextQuote():Quotes?{
        index++
        return if(index > 0 && index<quoteList.size){
            quoteList[index]
        }else{
            null
        }
    }
    fun previousQuote(): Quotes? {
        --index
        return if(index > 0 && index<quoteList.size){
            quoteList[index]
        }else{
            null
        }

    }
}