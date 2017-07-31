package com.segunfamisa.kotlin.samples.retrofit

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.TextView
import com.segunfamisa.kotlin.samples.retrofit.data.kotlin.SearchRepositoryProvider
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity() {

    val compositeDisposable: CompositeDisposable = CompositeDisposable()
    val message : TextView by lazy { findViewById(R.id.message) as TextView }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Note: the only code changes from this is to use textview
        val repository = SearchRepositoryProvider.provideSearchRepository()
        compositeDisposable.add(
                repository.searchUsers("Lagos", "Java")
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeOn(Schedulers.io())
                        .subscribe ({
                            result ->
                            Log.d("Result", "There are ${result.items.size} Java developers in Lagos")
                            message.text = "There are ${result.items.size} Java developers in Lagos"
                        }, { error ->
                            error.printStackTrace()
                        })
        )
    }

    override fun onDestroy() {
        compositeDisposable.clear()
        super.onDestroy()
    }
}
