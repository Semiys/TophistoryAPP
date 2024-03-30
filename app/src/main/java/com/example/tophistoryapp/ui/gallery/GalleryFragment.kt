package com.example.tophistoryapp.ui.gallery
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tophistoryapp.R
import com.example.tophistoryapp.databinding.FragmentGalleryBinding
import kotlinx.parcelize.Parcelize


class GalleryFragment : Fragment(), GalleryAdapter.OnItemClickListener {

    private var _binding: FragmentGalleryBinding? = null
    private val binding get() = _binding!!
    private lateinit var galleryAdapter: GalleryAdapter
    private lateinit var yourFullItemList: List<GalleryAdapter.StreetItem>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGalleryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Инициализация списка элементов с использованием getString()
        yourFullItemList = listOf(
            GalleryAdapter.StreetItem("Улица Аблукова", getString(R.string.ablukov), R.drawable.ablukov),
            GalleryAdapter.StreetItem("Misha Abobus", getString(R.string.ablukov), R.drawable.image2)
            // ... добавьте остальные элементы
        )

        // Инициализация RecyclerView и его адаптера
        galleryAdapter = GalleryAdapter()
        galleryAdapter.setOnItemClickListener(this)
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
    }

    private fun performSearch(query: String) {
        val filteredList = yourFullItemList.filter { it.name.contains(query, ignoreCase = true) }
        galleryAdapter.setItems(filteredList)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onItemClick(item: GalleryAdapter.StreetItem) {
        // Обработка нажатия на элемент
        val intent = Intent(context, DetailActivity::class.java).apply {
            putExtra("ITEM_KEY", item)
        }
        startActivity(intent)
    }
    // ... класс GalleryAdapter без изменений
}
class GalleryAdapter : RecyclerView.Adapter<GalleryAdapter.ViewHolder>() {

    private var items: List<StreetItem> = listOf()
    private var listener: OnItemClickListener? = null

    @SuppressLint("NotifyDataSetChanged")
    fun setItems(newItems: List<StreetItem>) {
        items = newItems
        notifyDataSetChanged()
    }

    fun setOnItemClickListener(listener: OnItemClickListener) {
        this.listener = listener
    }

    interface OnItemClickListener {
        fun onItemClick(item: StreetItem)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_gallery, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position],listener)
    }

    override fun getItemCount() = items.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: StreetItem, listener: OnItemClickListener?) {
            itemView.findViewById<TextView>(R.id.textViewItem).text = item.name
            itemView.setOnClickListener {
                listener?.onItemClick(item)
            }
        }
    }
    @Parcelize
    data class StreetItem(
        val name: String,
        val description: String,
        val imageResId: Int
    ) : Parcelable

}