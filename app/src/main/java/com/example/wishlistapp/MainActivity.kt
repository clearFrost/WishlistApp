package com.example.wishlistapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    lateinit var wishlists: List<Wishlist>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    val itemInput = findViewById<EditText>(R.id.itemNameEt)
    val priceInput = findViewById<EditText>(R.id.priceEt)
    val urlInput = findViewById<EditText>(R.id.urlEt)
    val submitButton = findViewById<Button>(R.id.submitBtn)

    val wishlistsRv = findViewById<RecyclerView>(R.id.wishlistRv)
    val adapter = WishlistAdapter(listOf(Wishlist(itemName = "", itemPrice = "", websiteURL = "")))
    wishlistsRv.adapter = adapter
    wishlistsRv.layoutManager = LinearLayoutManager(this)

    submitButton.setOnClickListener {
        val newWish = Wishlist(itemInput.text.toString(), priceInput.text.toString(), urlInput.text.toString())
        adapter.addToWishlist(adapter.wishlists + newWish)
        adapter.notifyDataSetChanged()
        Log.d("MyDebugTag",itemInput.text.toString())
        itemInput.text.clear()
        priceInput.text.clear()
        urlInput.text.clear()
    }
    }

}