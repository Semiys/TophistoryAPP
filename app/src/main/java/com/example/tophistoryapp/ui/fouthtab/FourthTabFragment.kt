package com.example.tophistoryapp.ui.fouthtab

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import com.example.tophistoryapp.databinding.FragmentFourthTabBinding

class FourthTabFragment : Fragment() {

    private var _binding: FragmentFourthTabBinding? = null
    private val binding get() = _binding!!

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentFourthTabBinding.inflate(inflater, container, false)
        val view = binding.root

        // Настройка WebView
        binding.webview.apply {
            webViewClient = WebViewClient()// Устанавливаем WebViewClient для внутренней навигации
            settings.javaScriptEnabled = true
            loadUrl("https://docs.google.com/forms/d/e/1FAIpQLSeDe33BtUw3dA2W6VMnTOyn49w9aXfuKGTDoK8afU_xlgBi4Q/viewform?usp=sf_link") // Здесь укажите URL вашей Google Формы
        }

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

