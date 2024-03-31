package com.example.tophistoryapp.ui.gallery

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.tophistoryapp.R

@Suppress("DEPRECATION")
class DetailActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        // Получаем переданный элемент
        val item = intent.getParcelableExtra<GalleryAdapter.StreetItem>("ITEM_KEY")
        supportActionBar?.title = item?.name

        // Находим TextView и устанавливаем текст элемента
        item?.let {
            findViewById<TextView>(R.id.descriptionTextView).text = it.description
            findViewById<ImageView>(R.id.imageView).setImageResource(it.imageResId)
        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)



    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                finish() // Закрыть текущую активность
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}