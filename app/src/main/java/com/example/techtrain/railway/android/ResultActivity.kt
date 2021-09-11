package com.example.techtrain.railway.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.techtrain.railway.android.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.d("MainActivity", "クリエイト")

        binding = ActivityResultBinding.inflate(layoutInflater).apply {
            setContentView(this.root)
        }

        val message = intent.getStringExtra("KEY_INPUT_TEXT")

        binding.resultTextView.text = message
    }

    override fun onStart() {
        super.onStart()
        Log.d("MainActivity", "スタート")
    }

    override fun onResume() {
        super.onResume()
        Log.d("MainActivity", "リジューム")
    }

    override fun onPause() {
        super.onPause()
        Log.d("MainActivity", "パース")
    }

    override fun onStop() {
        super.onStop()
        Log.d("MainActivity", "ストップ")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("MainActivity", "デストロイ")
    }
}
