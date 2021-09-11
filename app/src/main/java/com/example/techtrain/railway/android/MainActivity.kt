package com.example.techtrain.railway.android

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.techtrain.railway.android.databinding.ActivityMainBinding

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
            sendMessage()
        }

        // リアルタイムで editText に入力している文字を textView に反映させる。
//        editText.addTextChangedListener {
//            textView.text = it.toString()
//        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("MainActivity", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("MainActivity", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("MainActivity", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("MainActivity", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("MainActivity", "onDestroy")
    }

    fun sendMessage() {
        val message = binding.editText.text.toString()
        val intent = Intent(this, ResultActivity::class.java).apply {
            putExtra("KEY_INPUT_TEXT", message)
        }
        startActivity(intent)
    }
}
