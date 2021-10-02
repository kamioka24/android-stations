package com.example.techtrain.railway.android

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.techtrain.railway.android.Adapter.BookViewAdapter
import com.example.techtrain.railway.android.Repository.BookRepository
import com.example.techtrain.railway.android.databinding.ActivityMainBinding
import com.example.techtrain.railway.android.databinding.BookListBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    // ViewBinding の必須設定 (Activity 編) ① ~ ③

    // ① binding クラスを lateinit var で宣言。
    private lateinit var binding: ActivityMainBinding

    val bookList = mutableListOf<Book>()
    val adapter = BookViewAdapter(this, bookList)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.d("MainActivity", "onCreate")

        // ② binding の初期化とついでに setContentView も行う。
        binding = ActivityMainBinding.inflate(layoutInflater).apply {
            setContentView(this.root)
        }

        // ③ アクセスしたい View の id は勝手にキャメルケースに代わる。

        binding.button.setOnClickListener {
            // RecyclerViewにAdapterとLayoutManagerを設定
            binding.bookRecyclerView.also {
                    recyclerView: RecyclerView ->
                recyclerView.adapter = adapter
                recyclerView.layoutManager = LinearLayoutManager(this)
            }
        }
        sendApi()
    }


//    fun sendMessage() {
//        val message = binding.editText.text.toString()
//        val intent = Intent(this, ResultActivity::class.java).apply {
//            putExtra("KEY_INPUT_TEXT", message)
//        }
//        startActivity(intent)
//    }

    fun sendApi() {
        val service = BookRepository().getRetrofit()
//        val scope = CoroutineScope(Dispatchers.IO) // IO = サブスレッド

//        scope.launch {
        try {
            service.getRawResponseForPosts().enqueue(object : Callback<List<Book>> {
                override fun onResponse(
                    call: Call<List<Book>>,
                    response: Response<List<Book>>
                ) {
                    Log.d("MainActivity", "成功！！")
                    val book = response.body()
                    book?.let { bookList.addAll(book) }
                    adapter.notifyDataSetChanged() // recyclerView の更新（データ更新時）
                }

                override fun onFailure(call: Call<List<Book>>, t: Throwable) {
                    Log.d("MainActivity", "失敗！！")
                }
            })
//            text.postValue(get.toString()) // サブスレッドで処理したものをメインスレッドに投げる
        } catch (e: Exception) {
            Log.d("MainActivity", "失敗！！:" + e.message)
        }
    }
}
