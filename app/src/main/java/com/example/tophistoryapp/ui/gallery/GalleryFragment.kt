package com.example.tophistoryapp.ui.gallery
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.tophistoryapp.databinding.FragmentGalleryBinding

class GalleryFragment : Fragment() {

    private var _binding: FragmentGalleryBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val galleryViewModel = ViewModelProvider(this).get(GalleryViewModel::class.java)
        _binding = FragmentGalleryBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // Настройка SearchView
        val searchView: androidx.appcompat.widget.SearchView = binding.searchView
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                // Вы можете реализовать логику для обработки поискового запроса при его отправке
                query?.let { performSearch(it) }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                // Вы можете реализовать логику для обработки изменения текста поиска в реальном времени
                newText?.let { performSearch(it) }
                return true
            }
        })

        return root
    }

    private fun performSearch(query: String) {
        // Здесь вы должны реализовать логику фильтрации данных в зависимости от вашего запроса
        // Например, если у вас есть список элементов, вы можете фильтровать этот список и обновлять адаптер вашего RecyclerView
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}