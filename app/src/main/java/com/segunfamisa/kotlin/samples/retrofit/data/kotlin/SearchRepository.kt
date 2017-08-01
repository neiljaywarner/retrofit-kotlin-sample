package com.segunfamisa.kotlin.samples.retrofit.data.kotlin

import retrofit2.Call
import retrofit2.Response

/**
 * Repository method to access search functionality of the api service
 */
class SearchRepository(val apiService: GithubApiService) {

    fun searchUsers(location: String, language: String): List<User>? {
        val call : Call<Result> = apiService.search(query = "location:$location language:$language")
        val result = call.execute()
        if (result.isSuccessful) {
            return result.body()?.items;
        } else {
            throw Exception(result.errorBody().toString());
        }
    }
}