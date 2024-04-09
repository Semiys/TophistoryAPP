package com.example.tophistoryapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.commit
import com.example.tophistoryapp.ui.home.HomeFragment
import com.yandex.mapkit.MapKitFactory

class MainActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val button: AppCompatButton = findViewById(R.id.button)
        button.setOnClickListener {
            // Запускаем MainActivity
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            // Закрываем MainActivity2
            finish()
        }
    }
}