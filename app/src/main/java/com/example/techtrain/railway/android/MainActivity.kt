package com.example.techtrain.railway.android

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var textView = findViewById<TextView>(R.id.textView)
        textView.text = "ここが変わるよ！"
//        findViewById<ImageView>(R.id.imageView).setImageResource(R.color.black)

        var editText = findViewById<EditText>(R.id.editText)
        val button = findViewById<Button>(R.id.button)

        button.setOnClickListener {
            textView.text = editText.text.toString()
        }

        // リアルタイムで editText に入力している文字を textView に反映させる。
//        editText.addTextChangedListener {
//            textView.text = it.toString()
//        }
    }
}
