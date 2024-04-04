package com.example.tophistoryapp.ui.gallery

import android.annotation.SuppressLint
import android.graphics.Typeface
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.style.RelativeSizeSpan
import android.text.style.StyleSpan
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.tophistoryapp.R
import java.util.regex.Pattern

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
            findViewById<ImageView>(R.id.imageView).setImageResource(it.imageResId)
            val descriptionTextView = findViewById<TextView>(R.id.descriptionTextView)
            val spannableDescription = SpannableString(it.description)
            val pattern = Pattern.compile("\\b([A-ZА-Я])") // Паттерн для поиска заглавных букв
            val matcher = pattern.matcher(spannableDescription)
            while (matcher.find()) {
                spannableDescription.setSpan(
                    StyleSpan(Typeface.BOLD), // Жирный шрифт
                    matcher.start(), // Начальная позиция
                    matcher.end(), // Конечная позиция
                    Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
                )
                spannableDescription.setSpan(
                    RelativeSizeSpan(1.5f), // Увеличение размера текста
                    matcher.start(),
                    matcher.end(),
                    Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
                )
            }
            descriptionTextView.text = spannableDescription
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