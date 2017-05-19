package com.accubits.polylinesample;

import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import java.util.ArrayList;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private List<LatLng> latLngList = new ArrayList<>();
    private Polyline line;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
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
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(38.999604, -77.024341);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Silver Spring"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, 18));
//        mMap.moveCamera(CameraUpdateFactory.zoomBy(20));
        addLocationsToList();
        drawPolyLine();

        //  mMap.getUiSettings().isCompassEnabled();
        //  mMap.getUiSettings().setIndoorLevelPickerEnabled(true);
    }

    private void addLocationsToList() {

        latLngList.add(new LatLng(38.999684, -77.024341));
        latLngList.add(new LatLng(38.999034, -77.024142));
      //  latLngList.add(new LatLng(38.000174, -77.024515));
        latLngList.add(new LatLng(38.999860, -77.024665));
        latLngList.add(new LatLng(38.999997, -77.024977));
        latLngList.add(new LatLng(38.999944, -77.025211));
        latLngList.add(new LatLng(38.999712, -77.024897));

    }

    private void drawPolyLine() {
        PolylineOptions options = new PolylineOptions().width(5).color(Color.BLUE).geodesic(true);
        for (int z = 0; z < latLngList.size(); z++) {
            LatLng point = latLngList.get(z);
            options.add(point);
        }
        line = mMap.addPolyline(options);
        Log.i("RESP", line.getWidth() + " width");
    }
}
