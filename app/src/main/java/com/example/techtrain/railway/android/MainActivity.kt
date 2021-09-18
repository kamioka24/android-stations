package com.example.techtrain.railway.android

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.techtrain.railway.android.Repository.BookRepository
import com.example.techtrain.railway.android.ViewModel.MainViewModel
import com.example.techtrain.railway.android.databinding.ActivityMainBinding
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    // ViewBinding の必須設定 (Activity 編) ① ~ ③

    // ① binding クラスを lateinit var で宣言。
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.d("MainActivity", "onCreate")

        // ② binding の初期化とついでに setContentView も行う。
        binding = ActivityMainBinding.inflate(layoutInflater).apply {
            setContentView(this.root)
        }

        // ③ アクセスしたい View の id は勝手にキャメルケースに代わる。
//        binding.textView.text = "ここが変わるよ！！"
//
//        binding.button.setOnClickListener {
//            binding.textView.text = binding.editText.text.toString()
//        }

        binding.resultButton.setOnClickListener {
            sendApi()
        }

//        MainViewModel().text.observe(this, { text ->
//            binding.textView.text = text
//        })

        // リアルタイムで editText に入力している文字を textView に反映させる。
//        editText.addTextChangedListener {
//            textView.text = it.toString()
//        }
    }

//    override fun onStart() {
//        super.onStart()
//        Log.d("MainActivity", "onStart")
//    }
//
//    override fun onResume() {
//        super.onResume()
//        Log.d("MainActivity", "onResume")
//    }
//
//    override fun onPause() {
//        super.onPause()
//        Log.d("MainActivity", "onPause")
//    }
//
//    override fun onStop() {
//        super.onStop()
//        Log.d("MainActivity", "onStop")
//    }
//
//    override fun onDestroy() {
//        super.onDestroy()
//        Log.d("MainActivity", "onDestroy")
//    }

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
                    val books = response.body() ?: return
                    binding.textView.text = books.toString()
                }

                override fun onFailure(call: Call<List<Book>>, t: Throwable) {
                    Log.d("MainActivity", "失敗！！")
                }
            })
//            text.postValue(get.toString()) // サブスレッドで処理したものをメインスレッドに投げる
        } catch (e: Exception) {
            Log.d("MainActivity", "失敗！！:" + e.message)
            binding.textView.text = "失敗！！"
        }
    }
}
