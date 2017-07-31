package com.segunfamisa.kotlin.samples.retrofit

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.TextView
import com.segunfamisa.kotlin.samples.retrofit.data.kotlin.SearchRepositoryProvider

import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import org.jetbrains.anko.coroutines.experimental.bg


class MainActivity : AppCompatActivity() {

    val message : TextView by lazy { findViewById(R.id.message) as TextView }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadInfo()

    }

    private fun loadInfo() = async(UI) {

        val repository = SearchRepositoryProvider.provideSearchRepository()
        val result = bg { repository.searchUsers("Lagos", "Java")}
        val size = result.await()?.size
        Log.d("Result", "There are ${size} Java developers in Lagos")
        message.text = "There are ${size} Java developers in Lagos"
    }
}
