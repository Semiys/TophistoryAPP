package com.example.tophistoryapp.ui.gallery
import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tophistoryapp.R
import com.example.tophistoryapp.databinding.FragmentGalleryBinding

class GalleryFragment : Fragment() {

    private var _binding: FragmentGalleryBinding? = null
    private val binding get() = _binding!!
    private lateinit var galleryAdapter: GalleryAdapter
    private var yourFullItemList = listOf("Item 1", "Item 2", "Item 3") // Замените это вашим полным списком элементов

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGalleryBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // Инициализация RecyclerView и его адаптера
        galleryAdapter = GalleryAdapter()
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.adapter = galleryAdapter
        galleryAdapter.setItems(yourFullItemList)

        // Настройка SearchView
        binding.searchView.setOnQueryTextListener(object : androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                query?.let { performSearch(it) }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                newText?.let { performSearch(it) }
                return true
            }
        })

        return root
    }

    private fun performSearch(query: String) {
        val filteredList = yourFullItemList.filter { it.contains(query, ignoreCase = true) }
        galleryAdapter.setItems(filteredList)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

class GalleryAdapter : RecyclerView.Adapter<GalleryAdapter.ViewHolder>() {

    private var items: List<String> = listOf()

    @SuppressLint("NotifyDataSetChanged")
    fun setItems(newItems: List<String>) {
        items = newItems
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_gallery, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: String) {
            // Пример привязки текста к TextView в вашем item_gallery.xml
            // Предположим, что у вас есть TextView с id textViewItem
            itemView.findViewById<TextView>(R.id.textViewItem).text = item
        }
    }
}