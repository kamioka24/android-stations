package com.example.techtrain.railway.android.Repository

import com.example.techtrain.railway.android.BookApi
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class BookRepository {
//    val moshi = Moshi.Builder()
//        .add(KotlinJsonAdapterFactory())
//        .build()

    fun getRetrofit() = Retrofit.Builder()
        .baseUrl(BookApi.BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create())
        .build()
        .create(BookApi::class.java)
}
