package com.segunfamisa.kotlin.samples.retrofit

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.TextView
import com.segunfamisa.kotlin.samples.retrofit.data.kotlin.SearchRepository
import com.segunfamisa.kotlin.samples.retrofit.data.kotlin.SearchRepositoryProvider

import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import org.jetbrains.anko.coroutines.experimental.bg


class MainActivity : AppCompatActivity() {

    val message : TextView by lazy { findViewById(R.id.message) as TextView }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Note: the only code changes from this is to use textview
        val repository = SearchRepositoryProvider.provideSearchRepository()

        loadInfo(repository)

    }

    private fun loadInfo(repository: SearchRepository) = async(UI) {

        val result = bg { repository.searchUsers("Lagos", "Java")}
        val size = result.await()?.size
        Log.d("Result", "There are ${size} Java developers in Lagos")
        message.text = "There are ${size} Java developers in Lagos"
    }
}
