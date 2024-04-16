package com.example.tophistoryapp.ui.gallery
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
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
            GalleryAdapter.StreetItem("Улица Алашеева", getString(R.string.alashaev), R.drawable.alasheev),
            GalleryAdapter.StreetItem("Улица Гастелло", getString(R.string.gastello), R.drawable.gastello),
            GalleryAdapter.StreetItem("Улица Герасимова", getString(R.string.gerasimov), R.drawable.gerasimov),
            GalleryAdapter.StreetItem("Улица Доватора", getString(R.string.dovatora), R.drawable.dovatopa),
            GalleryAdapter.StreetItem("Улица Мельникова", getString(R.string.melnikov), R.drawable.melnikov),
            GalleryAdapter.StreetItem("Улица Панфиловцев", getString(R.string.panfilovcev), R.drawable.panfilovec),
            GalleryAdapter.StreetItem("Улица Полбина", getString(R.string.polbin), R.drawable.polbin),
            GalleryAdapter.StreetItem("Улица Прокофьева", getString(R.string.prokofev), R.drawable.prokofiev),
            GalleryAdapter.StreetItem("Улица Хваткова", getString(R.string.hvatkov), R.drawable.hvatkova),
            GalleryAdapter.StreetItem("Улица Черняховского", getString(R.string.chernyahovskiy), R.drawable.chernyxovsk),
            GalleryAdapter.StreetItem("Улица Шигаева", getString(R.string.shigaev), R.drawable.shigaev),
            // Засвияжский район закрыт.
            // Заволжский район открыт..
            GalleryAdapter.StreetItem("Улица Алексея Наганова", getString(R.string.naganov), R.drawable.naganovv),
            GalleryAdapter.StreetItem("Улица Врача Михайлова", getString(R.string.mixailovv), R.drawable.mixailov),
            GalleryAdapter.StreetItem("Улица Генерала Кашубы", getString(R.string.kashubas), R.drawable.kashuba),
            GalleryAdapter.StreetItem("Проспект Генерала Маргелова", getString(R.string.margelovv), R.drawable.margelov),
            GalleryAdapter.StreetItem("Проспект Генерала Тюленева", getString(R.string.tulenevv), R.drawable.tulenev),
            GalleryAdapter.StreetItem("Улица Гусева", getString(R.string.gusevv), R.drawable.gusev),
            GalleryAdapter.StreetItem("Улица Деева", getString(R.string.deevv), R.drawable.deev),
            GalleryAdapter.StreetItem("Улица Карбышева", getString(R.string.karbishevv), R.drawable.karbishev),
            GalleryAdapter.StreetItem("Улица Лизы Чайкиной", getString(R.string.chaikinaa), R.drawable.chaikina),
            GalleryAdapter.StreetItem("Улица Марии Мусоровой", getString(R.string.musorоvaa), R.drawable.musorova),
            GalleryAdapter.StreetItem("Переулок Тузова", getString(R.string.tuzov), R.drawable.portrait),
            GalleryAdapter.StreetItem("Улица Шурова", getString(R.string.shurovv), R.drawable.shurov),
            // Заволжский район закрыт.
            // Железнодорожный район открыт.
            GalleryAdapter.StreetItem("Улица Героев Свири", getString(R.string.geroi_sviri), R.drawable.baryshev),
            GalleryAdapter.StreetItem("Проезд Героя России Аверьянова", getString(R.string.averinovaa), R.drawable.averinova),
            GalleryAdapter.StreetItem("Улица Каштанкина", getString(R.string.kashtankinn), R.drawable.kashtankin),
            GalleryAdapter.StreetItem("Улица Расковой", getString(R.string.rackovaa), R.drawable.rackova),
            GalleryAdapter.StreetItem("Улица Хазова", getString(R.string.hazovaa), R.drawable.hazova),
            // Железнодорожный район закрыт.
            // Ленинский район открыт.
            GalleryAdapter.StreetItem("Улица Александра Матросова", getString(R.string.matrosovv), R.drawable.matrosov),
            GalleryAdapter.StreetItem("Улица Ватутина", getString(R.string.vatutinn), R.drawable.vatutin),
            GalleryAdapter.StreetItem("Улица Генерала Табакина", getString(R.string.tabakinn), R.drawable.tabakin),
            GalleryAdapter.StreetItem("Улица Зои Космодемьянской", getString(R.string.kosmoss), R.drawable.kosmos),
            GalleryAdapter.StreetItem("Улица Корюкина", getString(R.string.korushkinaa), R.drawable.korushkina),
            GalleryAdapter.StreetItem("Улица Любови Шевцовой", getString(R.string.shevcovaa), R.drawable.shevcova),
            GalleryAdapter.StreetItem("Улица Олега Кошевого", getString(R.string.koshegovaa), R.drawable.koshegova),
            GalleryAdapter.StreetItem("Улица Сергея Тюленина", getString(R.string.tulenevvsadsaasd), R.drawable.tulenevvsadsa),
            GalleryAdapter.StreetItem("Улица Толбухина", getString(R.string.tolbixinaa), R.drawable.tolbixina),
            GalleryAdapter.StreetItem("Улица Ульяны Громовой", getString(R.string.gromovaa), R.drawable.gromova),
            // Ленинский район закрыт.
            // Все улицы подряд
            GalleryAdapter.StreetItem("Улица Академика Корнилова", getString(R.string.kornilov), R.drawable.kornilovv),
            GalleryAdapter.StreetItem("Улица Академика Павлова", getString(R.string.pavlov), R.drawable.pavlovv),
            GalleryAdapter.StreetItem("Улица Академика Сахарова", getString(R.string.saharov), R.drawable.saharovv),
            GalleryAdapter.StreetItem("Улица Академика Тулайкова", getString(R.string.tulajkov), R.drawable.tulajkovv),
            GalleryAdapter.StreetItem("Улица Академика Филатова", getString(R.string.filatov), R.drawable.filatovv),
            GalleryAdapter.StreetItem("Улица Аксакова", getString(R.string.aksakov), R.drawable.aksakovv),
            GalleryAdapter.StreetItem("Улица Александра Невского", getString(R.string.nevskiy), R.drawable.nevskiyy),
            GalleryAdapter.StreetItem("Улица Александрова", getString(R.string.aleksandrov), R.drawable.aleksandrovv),
            GalleryAdapter.StreetItem("Улица Александровская", getString(R.string.aleksandovskaya), R.drawable.aleksandrovskayas),
            GalleryAdapter.StreetItem("Улица Алиева", getString(R.string.aliev), R.drawable.liyesv),
            GalleryAdapter.StreetItem("Улица Аношина", getString(R.string.anoshin), R.drawable.anoshinn),
            GalleryAdapter.StreetItem("Улица Антонова", getString(R.string.antonov), R.drawable.antonovv),
            GalleryAdapter.StreetItem("Улица Артема", getString(R.string.artema), R.drawable.artemas),
            GalleryAdapter.StreetItem("Улица Архитектора Ливчака", getString(R.string.livchak), R.drawable.livchakl),
            GalleryAdapter.StreetItem("Улица Архитектора Шодэ", getString(R.string.shode), R.drawable.shordes),
            GalleryAdapter.StreetItem("Улица Ашмарина", getString(R.string.ashmarin), R.drawable.ashmarins),
            GalleryAdapter.StreetItem("Улица Бабушкина", getString(R.string.babushkin), R.drawable.babushkingas),
            GalleryAdapter.StreetItem("Улица Баумана", getString(R.string.bauman), R.drawable.baumas),
            GalleryAdapter.StreetItem("Улица Бебеля", getString(R.string.bebel), R.drawable.bebeld),
            //32/330
            GalleryAdapter.StreetItem("Улица Белинского", getString(R.string.belinskiy), R.drawable.belinsky),
            GalleryAdapter.StreetItem("Улица Белова", getString(R.string.belov), R.drawable.belovv),
            GalleryAdapter.StreetItem("Улица Беляева", getString(R.string.belyaev), R.drawable.belayevv),
            GalleryAdapter.StreetItem("Улица Богдана Хмельницкого", getString(R.string.hmelnickiy), R.drawable.xmelinskyas),
            GalleryAdapter.StreetItem("Улица Богдана Хитрово", getString(R.string.hitrovo), R.drawable.hitrovos),
            GalleryAdapter.StreetItem("Улица Богданова", getString(R.string.bogdanov), R.drawable.bogdanosa),
            GalleryAdapter.StreetItem("Улица Бородина", getString(R.string.borodin), R.drawable.borodins),
            GalleryAdapter.StreetItem("Улица Брюханова", getString(R.string.bryhanov), R.drawable.bruhanov),
            GalleryAdapter.StreetItem("Улица Бутурлиных", getString(R.string.bytyrlin), R.drawable.fbuturlin),
            GalleryAdapter.StreetItem("Улица Варейкиса", getString(R.string.vareikis), R.drawable.vareikissa),
            GalleryAdapter.StreetItem("Улица Вершинина", getString(R.string.vershinin), R.drawable.vershinsain),
            //48/330
            GalleryAdapter.StreetItem("Улица Ярославского", getString(R.string.iroslavskiy), R.drawable.yaroslavskyi),
            GalleryAdapter.StreetItem("Улица Якурнова", getString(R.string.ikurnov), R.drawable.ikurnovv),
            GalleryAdapter.StreetItem("Улица Якупова", getString(R.string.yakupov), R.drawable.yakupovv),
            GalleryAdapter.StreetItem("Переулок Яковлева", getString(R.string.yalovlev), R.drawable.yakovlevvv),
            GalleryAdapter.StreetItem("Улица Языкова", getString(R.string.yazukov), R.drawable.yazukovvvv),
            GalleryAdapter.StreetItem("Улица Щорса", getString(R.string.shorsaa), R.drawable.shorsaas),
            GalleryAdapter.StreetItem("Улица Шпака", getString(R.string.shpaktovich), R.drawable.shpaktov),
            GalleryAdapter.StreetItem("Улица Шевченко", getString(R.string.shevchenko), R.drawable.shevchenkolatro),
            GalleryAdapter.StreetItem("Улица Чкалова", getString(R.string.chkalovskiy), R.drawable.chkalovvski),
            GalleryAdapter.StreetItem("Улица Чехова", getString(R.string.chexova), R.drawable.chexovasd),
            GalleryAdapter.StreetItem("Улица Чернышевского", getString(R.string.chernashvks), R.drawable.chernshevskiy),
            GalleryAdapter.StreetItem("Улица Чапаева", getString(R.string.chapaevskdf), R.drawable.chapaevsd),
            GalleryAdapter.StreetItem("Улица Чайковского", getString(R.string.chaikosvkys), R.drawable.chaikovsky),
            GalleryAdapter.StreetItem("Улица Циолковского", getString(R.string.cialkosvks), R.drawable.cialkosvkyas),
            GalleryAdapter.StreetItem("Проспект Хо Ши Мина", getString(R.string.shoshomina), R.drawable.hoshiminad),
            GalleryAdapter.StreetItem("Улица Фурманова", getString(R.string.farmond), R.drawable.furmanodvs),
            GalleryAdapter.StreetItem("Улица Фрунзе", getString(R.string.frunzeee), R.drawable.frunzee),
            GalleryAdapter.StreetItem("Улица Энгельса", getString(R.string.engelms), R.drawable.fridrixxd),
            GalleryAdapter.StreetItem("Переулок Ушакова", getString(R.string.ushakovskiy), R.drawable.ushakovvs),
            GalleryAdapter.StreetItem("Переулок Устинова", getString(R.string.ustinovs), R.drawable.ustinovsk),
            GalleryAdapter.StreetItem("Улица Урицкого", getString(R.string.urichkisay), R.drawable.uricskiyas),
            GalleryAdapter.StreetItem("Улица Тухачевского", getString(R.string.tuxachevskogo), R.drawable.tuhaxevs),
            GalleryAdapter.StreetItem("Улица Тургенева", getString(R.string.turgenev), R.drawable.turgenevds),
            GalleryAdapter.StreetItem("Проспект Туполева", getString(R.string.tupoleva), R.drawable.tupolevsd),
            GalleryAdapter.StreetItem("Улица Толбухина", getString(R.string.tolbuxon), R.drawable.tolbuxinsd),
            GalleryAdapter.StreetItem("Улица Тимирязева", getString(R.string.timirazev), R.drawable.timiraevsd),
            GalleryAdapter.StreetItem("Улица Терешковой", getString(R.string.tereshkovaddg), R.drawable.tereshkovad),
            GalleryAdapter.StreetItem("Улица Тельмана", getString(R.string.telmanadaf), R.drawable.telmanf),
            GalleryAdapter.StreetItem("Улица Сурова", getString(R.string.surovdgf), R.drawable.surovfsafas),
            GalleryAdapter.StreetItem("Улица Сурикова", getString(R.string.surikovsdas), R.drawable.surikovadad),
            GalleryAdapter.StreetItem("Переулок Суворова", getString(R.string.suvorodf), R.drawable.suvorodagasf),
            GalleryAdapter.StreetItem("Улица Столыпина", getString(R.string.stolapingds), R.drawable.stolapingsd),
            GalleryAdapter.StreetItem("Улица Гагарина", getString(R.string.gagarind), R.drawable.ggagarhfd),
            GalleryAdapter.StreetItem("Улица Гая", getString(R.string.gaysf), R.drawable.gsdsg),
            GalleryAdapter.StreetItem("Улица Карла Маркса", getString(R.string.karlmasga), R.drawable.gsdsg),
            GalleryAdapter.StreetItem("Улица Ленина", getString(R.string.leningad), R.drawable.lenintops),
            GalleryAdapter.StreetItem("Улица Льва Толстого", getString(R.string.rjsfjj), R.drawable.ggagh),

            // ... добавьте остальные элементы
        )

        // Инициализация RecyclerView и его адаптера
        galleryAdapter = GalleryAdapter()
        galleryAdapter.setOnItemClickListener(this)
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.adapter = galleryAdapter
        galleryAdapter.setItems(yourFullItemList)

        val dividerItemDecoration = DividerItemDecoration(binding.recyclerView.context, LinearLayoutManager.VERTICAL)
        binding.recyclerView.addItemDecoration(dividerItemDecoration)

        // Настройка SearchView
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
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