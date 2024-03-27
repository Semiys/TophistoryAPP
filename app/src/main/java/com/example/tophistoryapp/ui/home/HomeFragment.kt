package com.example.tophistoryapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.tophistoryapp.databinding.FragmentHomeBinding
import com.yandex.mapkit.Animation
import com.yandex.mapkit.MapKitFactory
import com.yandex.mapkit.geometry.Point
import com.yandex.mapkit.map.CameraPosition

@Suppress("DEPRECATION")
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private var cameraPosition: CameraPosition? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MapKitFactory.setApiKey("b24e54ca-8c0c-4986-a17a-091f18cbe011")
        MapKitFactory.initialize(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        ViewModelProvider(this)[HomeViewModel::class.java]

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        cameraPosition?.let {
            binding.mapview.map.move(it)
        } ?: run {
            // Иначе устанавливаем начальную позицию камеры
            binding.mapview.map.move(
                CameraPosition(Point(54.351655, 48.389395), 16.0f, 0.0f, 0.0f),
                Animation(Animation.Type.SMOOTH, 2.5f),
                null
            )
        }


        return root
    }
    override fun onPause() {
        super.onPause()
        // Сохраняем текущее положение камеры
        cameraPosition = binding.mapview.map.cameraPosition
    }

    override fun onResume() {
        super.onResume()
        // Восстанавливаем позицию камеры
        cameraPosition?.let {
            binding.mapview.map.move(it)
        }
    }

    override fun onStart() {
        super.onStart()
        binding.mapview.onStart()
        MapKitFactory.getInstance().onStart()
    }

    override fun onStop() {
        super.onStop()
        binding.mapview.onStop()
        MapKitFactory.getInstance().onStop()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}