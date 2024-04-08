package com.example.tophistoryapp.ui.home

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.tophistoryapp.R
import com.example.tophistoryapp.databinding.FragmentHomeBinding
import com.yandex.mapkit.Animation
import com.yandex.mapkit.MapKitFactory
import com.yandex.mapkit.geometry.Point
import com.yandex.mapkit.location.LocationListener
import com.yandex.mapkit.location.LocationManager
import com.yandex.mapkit.location.LocationStatus
import com.yandex.mapkit.map.CameraPosition
import com.yandex.mapkit.map.MapObjectCollection
import com.yandex.mapkit.mapview.MapView
import com.yandex.runtime.image.ImageProvider

@Suppress("DEPRECATION")
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private var cameraPosition: CameraPosition? = null
    private var mapView: MapView? = null
    private lateinit var locationManager: LocationManager
    private var mapObjects: MapObjectCollection? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MapKitFactory.setApiKey("b24e54ca-8c0c-4986-a17a-091f18cbe011")
        MapKitFactory.initialize(requireContext())
        locationManager = MapKitFactory.getInstance().createLocationManager()

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root


        mapView = binding.mapview
        mapObjects = mapView?.map?.mapObjects?.addCollection()

        binding.buttonLocation.setOnClickListener {
            checkLocationPermission()
        }

        return root
    }

    private fun checkLocationPermission() {
        if (ContextCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                requireActivity(),
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                LOCATION_PERMISSION_REQUEST_CODE
            )
        } else {
            moveToUserLocation()
        }
    }

    private fun moveToUserLocation() {
        if (ContextCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.ACCESS_FINE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            locationManager.requestSingleUpdate(object : LocationListener {
                override fun onLocationUpdated(location: com.yandex.mapkit.location.Location) {
                    mapView?.map?.move(
                        CameraPosition(Point(location.position.latitude, location.position.longitude), 16.0f, 0.0f, 0.0f),
                        Animation(Animation.Type.SMOOTH, 2.5f),
                        null

                    )
                    mapObjects?.clear()
                    val userLocation = Point(location.position.latitude, location.position.longitude)
                    val placemark = mapObjects?.addPlacemark(userLocation)
                     // Если вам не нужно изменять прозрачность метки, эту строку можно удалить
                    placemark?.setIcon(ImageProvider.fromResource(requireContext(), R.drawable.ghtswtops))
                    mapView?.map?.move(
                        CameraPosition(userLocation, 16.0f, 0.0f, 0.0f),
                        Animation(Animation.Type.SMOOTH, 2.5f),
                        null
                    )
                }

                override fun onLocationStatusUpdated(status: LocationStatus) {
                    if (status == LocationStatus.NOT_AVAILABLE) {
                        Toast.makeText(requireContext(), "Location is not available", Toast.LENGTH_SHORT).show()
                    }
                }
            })
        }
    }

    @Deprecated("Deprecated in Java")
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == LOCATION_PERMISSION_REQUEST_CODE) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                moveToUserLocation()
            } else {
                Toast.makeText(
                    requireContext(),
                    "Location permission denied",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    override fun onPause() {
        super.onPause()
        cameraPosition = mapView?.map?.cameraPosition
    }

    override fun onResume() {
        super.onResume()
        cameraPosition?.let { cameraPosition ->
            mapView?.map?.move(cameraPosition)
        }
    }

    override fun onStart() {
        super.onStart()
        mapView?.onStart()
        MapKitFactory.getInstance().onStart()
    }

    override fun onStop() {
        super.onStop()
        mapView?.onStop()
        MapKitFactory.getInstance().onStop()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        mapView = null
    }

    companion object {
        const val LOCATION_PERMISSION_REQUEST_CODE = 1001
    }



}
