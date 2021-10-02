package com.example.techtrain.railway.android

import retrofit2.Call
import retrofit2.http.GET

interface BookApi {

    companion object {
        const val BASE_URL = "https://techtrain-railway-api.herokuapp.com/"
    }

    @GET("public/books")
    // コルーチン必須 suspend
    fun getRawResponseForPosts(): Call<List<Book>>
}
