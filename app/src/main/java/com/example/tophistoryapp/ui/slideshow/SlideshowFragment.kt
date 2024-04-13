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

        binding.textViewAbout3.text = "    Представляем вашему вниманию проект\"История Улиц Ульяновска\", созданный с целью предоставления доступа к информации о истории улиц нашего города. Данный проект ориентирован на широкую аудиторию и предоставляет возможность ознакомиться с историческими сведениями о каждой улице Ульяновска, включая происхождение названия и связанные с ней события и личности.\n"+
                "\n"+
        "    Основой для создания информационной базы проекта стали улицы, названные в честь выдающихся исторических деятелей и личностей, внесших значительный вклад в историю города. Приложение предлагает удобный интерфейс и разнообразные функциональные возможности, позволяющие пользователям получить доступ к необходимой информации в удобном формате.\n"+
                "\n"+
                "    Приложение \"История Улиц Ульяновска\" обладает следующими особенностями:\n"+
                "\n"+
                "Подробная информация о каждой улице города, включая историю названия, ключевые события и исторические личности.\n" +
                "Удобный поиск информации по названию улицы.\n" +
                "Различные способы представления информации: текстовый и голосовой форматы.\n" +
                "Приглашаем вас погрузиться в увлекательный мир истории наших улиц с помощью приложения \"История Улиц Ульяновска\". Пользуйтесь нашим проектом и расширяйте свои знания о прошлом нашего города!\n"


        return root

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}