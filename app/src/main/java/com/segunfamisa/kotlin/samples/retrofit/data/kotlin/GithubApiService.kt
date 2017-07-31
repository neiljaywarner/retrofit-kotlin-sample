package com.segunfamisa.kotlin.samples.retrofit.data.kotlin

import retrofit2.Call

interface GithubApiService {

    @retrofit2.http.GET("search/users")
    fun search(@retrofit2.http.Query("q") query: String,
               @retrofit2.http.Query("page") page: Int = 1,
               @retrofit2.http.Query("per_page") perPage: Int = 20): Call<Result>


    /**
     * Companion object for the factory
     */
    companion object Factory {
        fun create(): com.segunfamisa.kotlin.samples.retrofit.data.kotlin.GithubApiService {
            val retrofit = retrofit2.Retrofit.Builder()
                    .addConverterFactory(retrofit2.converter.gson.GsonConverterFactory.create())
                    .baseUrl("https://api.github.com/")
                    .build()

            return retrofit.create(GithubApiService::class.java);
        }
    }
}