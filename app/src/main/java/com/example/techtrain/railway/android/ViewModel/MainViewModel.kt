package com.example.techtrain.railway.android.ViewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.techtrain.railway.android.Book
import com.example.techtrain.railway.android.Repository.BookRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel : ViewModel() {
//    val text = MutableLiveData<String>()
//
//    fun sendApi() {
//        val service = BookRepository().getRetrofit()
////        val scope = CoroutineScope(Dispatchers.IO) // IO = サブスレッド
//
////        scope.launch {
//        try {
//            service.getRawResponseForPosts().enqueue(object : Callback<List<Book>> {
//                override fun onResponse(
//                    call: Call<ResponseBody>,
//                    response: Response<ResponseBody>
//                ) {
//                    Log.d("MainActivity", "成功！！")
//                    val books = response.body() ?: return
//                    text.postValue(books.toString())
//                }
//
//                override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
//                    Log.d("MainActivity", "失敗！！")
//                }
//            })
////            text.postValue(get.toString()) // サブスレッドで処理したものをメインスレッドに投げる
//        } catch (e: Exception) {
//            Log.d("MainActivity", "失敗！！:" + e.message)
//            text.postValue("失敗！！")
//        }
////        }
//    }
}
