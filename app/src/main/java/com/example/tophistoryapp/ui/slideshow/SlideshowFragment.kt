package com.example.tophistoryapp.ui.slideshow

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.tophistoryapp.databinding.FragmentSlideshowBinding

class SlideshowFragment : Fragment() {

    private var _binding: FragmentSlideshowBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        ViewModelProvider(this).get(SlideshowViewModel::class.java)

        _binding = FragmentSlideshowBinding.inflate(inflater, container, false)
        val root: View = binding.root
        binding.textViewAbout3.text = "Дорогие друзья, курс на социально-ориентированный национальный проект в значительной степени обуславливает создание системы масштабного изменения ряда параметров. Не следует, однако, забывать о том, что повышение уровня гражданского сознания создаёт предпосылки качественно новых шагов для существующих финансовых и административных условий. Задача организации, в особенности же новая модель организационной деятельности позволяет выполнить важнейшие задания по разработке ключевых компонентов планируемого обновления.\n" +
                "\n" +
                "Таким образом, постоянный количественный рост и сфера нашей активности играет важную роль в формировании системы обучения кадров, соответствующей насущным потребностям. Дорогие друзья, дальнейшее развитие различных форм деятельности в значительной степени обуславливает создание соответствующих условий активизации. Таким образом, постоянный количественный рост и сфера нашей активности играет важную роль в формировании модели развития. Соображения высшего порядка, а также сложившаяся структура организации способствует подготовке и реализации дальнейших направлений развития проекта."


        return root

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}