package com.segunfamisa.kotlin.samples.retrofit

import android.os.Bundle
import android.os.Trace
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
        Log.e("BoomTest", "in mainThread onCreate")
        mainThreadMethod1()
    }

    private fun mainThreadMethod1() {
        Log.e("BoomTest", "in mainThreadMethod1")
        mainThreadMethod2_ReturnsDeferredViaAsync()
    }

    private fun mainThreadMethod2_ReturnsDeferredViaAsync() = async(UI) {
        Log.e("BoomTest", "in mainThreadMethod2_ReturnsDeferredViaAsync")
        try {
            val repository = SearchRepositoryProvider.provideSearchRepository()

            val result = bg { repository.backGroundMethod1("Lagos", "Java")}
            val size = result.await()?.size
            Log.d("Result", "There are ${size} Java developers in Lagos")
            message.text = "There are ${size} Java developers in Lagos"
        } catch (e : Exception) {
            Log.e("BoomTest", "boomfrom bg")
            Log.e("BoomTest", "----*************--------*************--------*************--------*************--------*************--------*************--------*************--------*************----")
            //Todo: print all elemenets before integratigng crashlytics, same idea?
            // or just do it... or tf
            logStackTrace(e)
            Log.e("BoomTest", "----*************--------*************--------*************--------*************--------*************--------*************--------*************--------*************----")


        }

        //TODO: put in and test ecpetion, if fail silently, obvioulsy bad

    }

    private fun logStackTrace(exception : Exception ) {
        Log.e("BoomTest", "Exception stacktrace array has ${exception.stackTrace.size} elements")
        exception.printStackTrace()

    }
}
