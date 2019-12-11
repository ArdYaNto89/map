package com.uty.map

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Spannable

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.*
import kotlinx.android.synthetic.main.activity_maps.*

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in Sydney and move the camera
        val latitude=-7.747033
        val longtitude=110.355398
        val rumah =LatLng(-7.7775608,110.345191)
        val zoomLevel=15f
        val overlaySize=100f
        val ent=LatLng(-7.767879,110.354262)
        val uty = LatLng(-7.765374,110.361156)

        val homeLatLng=LatLng(latitude,longtitude)
        mMap.addMarker(MarkerOptions().position(homeLatLng).title("UTY").icon(BitmapDescriptorFactory.
        defaultMarker(BitmapDescriptorFactory.HUE_GREEN)))
        mMap.addMarker(MarkerOptions().position(rumah).title("myHOME").icon(BitmapDescriptorFactory.
            defaultMarker(BitmapDescriptorFactory.HUE_CYAN)).icon(BitmapDescriptorFactory
            .fromResource(R.drawable.home)))
        mMap.addMarker(MarkerOptions().position(ent).title("Hiburan"))
        mMap.addMarker(MarkerOptions().position(uty).snippet("TVRI").title("siaran tv"))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(homeLatLng,zoomLevel))

        val googleOverlay=GroundOverlayOptions()
            .image(BitmapDescriptorFactory.fromResource(R.drawable.campus))
            .position(homeLatLng,overlaySize)
        mMap.addGroundOverlay(googleOverlay)

    }
}


