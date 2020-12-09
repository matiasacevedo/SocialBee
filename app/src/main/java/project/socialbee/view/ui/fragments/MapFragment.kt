package project.socialbee.view.ui.fragments

import android.graphics.Bitmap
import android.graphics.Color
import android.graphics.drawable.BitmapDrawable
import android.os.Build
import android.os.Bundle
import android.provider.ContactsContract.PinnedPositions.pin
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import androidx.fragment.app.DialogFragment
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.*
import kotlinx.android.synthetic.main.fragment_map.*
import project.socialbee.R
import project.socialbee.view.adapter.GeneralDataAdapter
import project.socialbee.view.adapter.GeneralDataListener
import project.socialbee.view.model.GeneralData
import project.socialbee.view.viewmodel.GeneralDataViewModel

class MapFragment : DialogFragment(),
                    OnMapReadyCallback,
                    GoogleMap.OnMarkerClickListener,
                    GeneralDataListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_map, container, false)
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment

        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap?) {

        val generalData = GeneralData()
        val zoom = 16f
        val centerMap = LatLng(-32.4773196, -58.2482894)
        googleMap?.animateCamera(CameraUpdateFactory.newLatLngZoom(centerMap, zoom))

        val centerMark = LatLng(-32.47482, -58.24149)
        val markerOptions = MarkerOptions()
        markerOptions.position(centerMark)
        markerOptions.title("User Test")

        val bitmapDraw = context?.applicationContext?.let { ContextCompat.getDrawable(it, R.drawable.pin) as BitmapDrawable }
        val smallMarker = bitmapDraw?.bitmap?.let { Bitmap.createScaledBitmap(it, 150, 150, false) }

        markerOptions.icon(BitmapDescriptorFactory.fromBitmap(smallMarker))

        googleMap?.addMarker(markerOptions)
        googleMap?.setOnMarkerClickListener(this)

        googleMap?.setMapStyle(MapStyleOptions.loadRawResourceStyle(context, R.raw.custom_map))


    }

    override fun onMarkerClick(p0: Marker?): Boolean {
        TODO("Not yet implemented")
    }

    override fun onSpeakerClicked(data: GeneralData, position: Int) {
        TODO("Not yet implemented")
    }


}