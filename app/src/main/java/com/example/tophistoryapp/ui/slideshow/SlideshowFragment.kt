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

        binding.textViewAbout3.text = "Проект \"История в улицах Ульяновска\"\n" +
                "\n" +
                "Уважаемые жители и гости города Ульяновска!\n"+
                "Мы рады представить вам наш проект \"История в улицах Ульяновска\" , который призван обогатить ваше знание о нашем \n" +
                "городе и его истории. Независимо от вашего возраста, вы найдете в нашем приложении увлекательную и информативную \n" +
                "информацию о каждой улице нашего города, включая историю ее названия и связанные с ней события и личности.\n"+
                "\n"+
                "Мы основываемся на улицах, которые были названы в честь выдающихся исторических личностей, благодаря которым \n" +
                "Ульяновск стал тем, чем он является сегодня. Удобный интерфейс нашего приложения и его функциональные возможности \n" +
                "позволяют вам получать доступ к интересующей вас информации в любое время и в любом месте.\n"+
                "\n"+
                "Просто откройте наше приложение, будучи на улице, и узнайте, где вы находитесь. У нас предусмотрен удобный поиск, \n" +
                "который поможет вам быстро найти информацию о выбранной улице. Кроме того, мы предлагаем различные способы \n" +
                "представления информации: текстовый и голосовой, чтобы каждый мог выбрать удобный для себя формат.\n"+
                "\n"+
                "Приглашаем вас отправиться в захватывающее путешествие по улицам Ульяновска вместе с нашим проектом \n" +
                "\"История в улицах Ульяновска\". Добро пожаловать в мир истории и открытий!"+
                "\n"+
                "С уважением,\n"+
                "Команда проекта \"История в улицах Ульяновска\""

        return root

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}