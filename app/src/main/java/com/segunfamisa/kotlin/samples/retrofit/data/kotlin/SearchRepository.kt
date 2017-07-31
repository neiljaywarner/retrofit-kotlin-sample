package com.segunfamisa.kotlin.samples.retrofit.data.kotlin

import retrofit2.Call

/**
 * Repository method to access search functionality of the api service
 */
class SearchRepository(val apiService: GithubApiService) {

    fun searchUsers(location: String, language: String): List<User>? {
        val call : Call<Result> = apiService.search(query = "location:$location language:$language")
        return call.execute().body()?.items
    }

}