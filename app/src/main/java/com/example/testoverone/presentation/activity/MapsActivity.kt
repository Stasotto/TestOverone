package com.example.testoverone.presentation.activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.testoverone.R
import com.example.testoverone.databinding.ActivityMapsBinding
import com.example.testoverone.presentation.models.DataWrapper
import com.example.testoverone.presentation.viewmodel.MapActivityViewModel
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import org.koin.androidx.viewmodel.ext.android.viewModel

class MapsActivity : AppCompatActivity(R.layout.activity_maps), OnMapReadyCallback {

    private var mMap: GoogleMap? = null
    private val binding: ActivityMapsBinding by viewBinding()
    private var launcher: ActivityResultLauncher<Intent>? = null
    private var point: LatLng? = null
    private val viewModel by viewModel<MapActivityViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startMap()
        createLauncher()
        deleteAllPoints()

        binding.filterActivity.setOnClickListener {
            openFilterActivity()
        }
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        val sydney = LatLng(-34.0, 151.0)
        mMap?.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
        mMap?.moveCamera(CameraUpdateFactory.newLatLng(sydney))
    }

    private fun openFilterActivity() {
        launcher?.launch(Intent(this, FilterActivity::class.java))

    }

    private fun createLauncher() {
        launcher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
                if (result.resultCode == RESULT_OK && result.data != null) {
                    val points = result.data?.extras?.get("key") as DataWrapper
                    points.list.map {

                        point = LatLng(it.lat, it.lan)
                        showNewPoint(point)
                    }

                }
            }
    }

    private fun showNewPoint(point: LatLng?) {
        mMap?.addMarker(MarkerOptions().position(point ?: LatLng(-34.0, 151.0)))
        mMap?.moveCamera((CameraUpdateFactory.newLatLng(point ?: LatLng(-34.0, 151.0))))
    }

    private fun startMap() {
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    private fun deleteAllPoints() {
        binding.delete.setOnClickListener {
            viewModel.deletePoint()
            mMap?.clear()
        }
    }
}