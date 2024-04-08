package com.example.tophistoryapp.ui.gallery

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.speech.tts.UtteranceProgressListener
import android.view.MenuItem
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.tophistoryapp.R
import java.util.*

class DetailActivity : AppCompatActivity(), TextToSpeech.OnInitListener {
    private lateinit var textToSpeech: TextToSpeech
    private lateinit var speakButton: Button
    private lateinit var descriptionTextView: TextView
    private var queue: Queue<String> = LinkedList()

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        // Инициализация TextToSpeech
        textToSpeech = TextToSpeech(this, this).apply {
            setOnUtteranceProgressListener(object : UtteranceProgressListener() {
                override fun onStart(utteranceId: String?) {
                    // Можно реализовать логику, если надо что-то делать при начале произношения
                }

                override fun onDone(utteranceId: String?) {
                    if (!queue.isEmpty()) {
                        speakOut(queue.poll())
                    }
                }

                override fun onError(utteranceId: String?) {
                    // Можно реализовать логику обработки ошибок
                }
            })
        }

        // Инициализация переменных View
        val imageView: ImageView = findViewById(R.id.imageView)
        descriptionTextView = findViewById(R.id.descriptionTextView)
        speakButton = findViewById(R.id.speakButton)

        // Получаем переданный элемент
        val item = intent.getParcelableExtra<GalleryAdapter.StreetItem>("ITEM_KEY")
        supportActionBar?.title = item?.name
        item?.let {
            imageView.setImageResource(it.imageResId)
            descriptionTextView.text = it.description
        }

        // Обработчик нажатия кнопки голосового воспроизведения
        speakButton.setOnClickListener {
            queue.clear()
            queue.addAll(descriptionTextView.text.toString().split(". ").map { it.trim() + "." })
            if (queue.isNotEmpty()) {
                speakOut(queue.poll())
            }
        }

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    // Функция воспроизведения текста
    private fun speakOut(text: String) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            textToSpeech.speak(text, TextToSpeech.QUEUE_FLUSH, null, UUID.randomUUID().toString())
        } else {
            @Suppress("DEPRECATION")
            textToSpeech.speak(text, TextToSpeech.QUEUE_FLUSH, null)
        }
    }

    override fun onInit(status: Int) {
        if (status == TextToSpeech.SUCCESS) {
            val result = textToSpeech.setLanguage(Locale("ru")) // Установка русского языка

            if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                // Язык данных отсутствует или не поддерживается
            } else {
                speakButton.isEnabled = true // Активируем кнопку, если все в порядке
            }
        } else {
            // Инициализация не удалась
        }
    }

    override fun onDestroy() {
        // Выполняем очистку
        if (::textToSpeech.isInitialized) {
            textToSpeech.stop()
            textToSpeech.shutdown()
        }
        super.onDestroy()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}