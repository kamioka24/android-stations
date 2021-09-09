package com.example.techtrain.railway.android

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import com.example.techtrain.railway.android.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // ViewBinding の必須設定 (Activity 編) ① ~ ③

    // ① binding クラスを lateinit var で宣言。
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)

        // ② binding の初期化とついでに setContentView も行う。
        binding= ActivityMainBinding.inflate(layoutInflater).apply {
            setContentView(this.root)
        }

        // ③ アクセスしたい View の id は勝手にキャメルケースに代わる。

        binding.textView.text = "ここが変わるよ！"

        binding.button.setOnClickListener {
            binding.textView.text = binding.editText.text.toString()
        }

        // リアルタイムで editText に入力している文字を textView に反映させる。
//        editText.addTextChangedListener {
//            textView.text = it.toString()
//        }
    }
}
