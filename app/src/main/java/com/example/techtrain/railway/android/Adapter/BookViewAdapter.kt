package com.example.techtrain.railway.android.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.techtrain.railway.android.Book
import com.example.techtrain.railway.android.R
import java.util.*

class BookViewAdapter(private val context: Context, private val bookList: List<Book>) : RecyclerView.Adapter<BookViewAdapter.BookViewHolder>() {

    class BookViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val bookTitle = view.findViewById<TextView>(R.id.book_title)
        val bookDetail = view.findViewById<TextView>(R.id.book_detail)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder =
        BookViewHolder(LayoutInflater.from(context).inflate(R.layout.book_list, parent, false))

    override fun getItemCount(): Int = bookList.size

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        holder.bookTitle.text = bookList[position].title
        holder.bookDetail.text = bookList[position].detail
    }
}