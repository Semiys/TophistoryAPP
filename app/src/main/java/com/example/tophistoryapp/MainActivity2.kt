package com.example.tophistoryapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.commit
import com.example.tophistoryapp.ui.home.HomeFragment

class MainActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        // Находим кнопку по ID
        val button: AppCompatButton = findViewById(R.id.button)

        // Устанавливаем обработчик нажатий на кнопку
        button.setOnClickListener {
            // Выполняем транзакцию фрагмента
            // Закрываем MainActivity2
            finish()
        }
    }
}