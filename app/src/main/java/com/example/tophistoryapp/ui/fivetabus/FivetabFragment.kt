package com.example.tophistoryapp.ui.fivetabus

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import com.example.tophistoryapp.databinding.FragmentFifthTabBinding


class FivetabFragment : Fragment() { // Добавляем наследование от Fragment
    private var _binding: FragmentFifthTabBinding? = null // Используем правильное имя класса Binding
    private val binding get() = _binding!!

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFifthTabBinding.inflate(inflater, container, false) // Используем правильное имя класса Binding
        val view = binding.root

        // Настройка WebView
        binding.webview.apply {
            webViewClient = WebViewClient() // Устанавливаем WebViewClient для внутренней навигации
            settings.javaScriptEnabled = true // Включаем поддержку JavaScript
            loadUrl("https://73online.ru/news") // Загружаем URL
        }

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null // Очищаем ссылку на Binding при уничтожении View
    }
}