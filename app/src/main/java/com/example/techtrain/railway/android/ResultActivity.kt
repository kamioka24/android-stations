package com.example.techtrain.railway.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.techtrain.railway.android.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityResultBinding.inflate(layoutInflater).apply {
            setContentView(this.root)
        }

        val message = intent.getStringExtra("KEY_INPUT_TEXT")

        binding.resultTextView.text = message
    }
}
