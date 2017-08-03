package com.segunfamisa.kotlin.samples.retrofit.data.kotlin

import android.util.Log
import retrofit2.Call
import retrofit2.Response
import java.io.IOException

/**
 * Repository method to access search functionality of the api service
 */
class SearchRepository(val apiService: GithubApiService) {
    // searchUsers() method
    fun backGroundMethod1(location: String, language: String): List<User>?  {
        //Log.d("NJW", "code=" + result.code() )
        Log.d("BoomTest", "In backGroundMethod1, about to run backGroundMethod2")
        backGroundMethod2()

        val call : Call<Result> = apiService.search(query = "location:$location language:$language")
        /*try {
            Log.e("NJW", "code=" + result.code() )

            val result = call.execute()
            Log.e("NJW", "code=" + result.code() )
            if (result.isSuccessful) {
                return result.body()?.items;
            } else {
                throw Exception(result.errorBody().toString());
            }
        } catch (e : IOException) {
            Log.e("NJW", "ioException" + e.message)
            return null
        }*/


        // TODO: Does it go to the main thread...
        return null;
    }

    fun backGroundMethod2() {
        Log.d("BoomTest", "In backgroundMethod2")
        throw Exception("boom: Exception in backgroundmethod2");
    }
}