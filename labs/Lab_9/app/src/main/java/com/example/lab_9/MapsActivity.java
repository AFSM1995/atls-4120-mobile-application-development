// Icon https://www.freepngimg.com/icon/66959-map-google-icons-maps-computer-systems-navigation

package com.example.lab_9;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    // https://developers.google.com/android/reference/com/google/android/gms/location/FusedLocationProviderClient
    // Retrieve the last known location.
    private FusedLocationProviderClient lastPhoneLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        lastPhoneLocation = LocationServices.getFusedLocationProviderClient(this);

        // We want to make sure we have permissions to get user location.
        if (ContextCompat.checkSelfPermission(this.getApplicationContext(), android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // Permission doesn't exist, so we request it.
            ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION}, 1);
        }

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.googleMap);
        mapFragment.getMapAsync(this);

        // Button for updating user location.
        FloatingActionButton fab = findViewById(R.id.findMeButton);
        fab.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                updateLocation(mMap);
            }
        });
    }

    // Add marker to map, zoom = false so it starts zoomed out.
    public void onMapReady(GoogleMap googleMap) {
        addMarker(googleMap, false);
    }

    // On button click, this is called, which updated location and animates to it.
    // How to use this function?
    // https://developer.android.com/training/location/receive-location-updates.
    public void updateLocation(GoogleMap googleMap) {
        addMarker(googleMap, true);
    }

    // How to use this function?
    // https://developers.google.com/maps/documentation/android-sdk/marker
    public void addMarker(GoogleMap googleMap, final boolean zoom) {
        mMap = googleMap;

        // Listener is called when a Task completes successfully.
        // https://stackoverflow.com/questions/44992014/how-to-get-current-location-in-googlemap-using-fusedlocationproviderclient
        lastPhoneLocation.getLastLocation().addOnSuccessListener(this, new OnSuccessListener<Location>() {

            public void onSuccess(Location userLocation) {
            // We want to make sure the location isn't null that will sometimes be sent.
            if (userLocation != null) {
                // Add marker to map, I also added a custom color.
                // https://stackoverflow.com/questions/19076124/android-map-marker-color
                LatLng marker = new LatLng(userLocation.getLatitude(), userLocation.getLongitude());
                mMap.addMarker(new MarkerOptions().position(marker).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)).title("The best person in the world is located right here"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(marker));

                // Colorado School Locations
                LatLng cuBoulder = new LatLng(40.0076, -105.2659);
                mMap.addMarker(new MarkerOptions().position(cuBoulder).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)).title("CU Boulder"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(cuBoulder));

                LatLng csu = new LatLng(40.5734, -105.0865);
                mMap.addMarker(new MarkerOptions().position(csu).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN)).title("Colorado State University"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(csu));

                LatLng cuDenver = new LatLng(39.6766, -104.9619);
                mMap.addMarker(new MarkerOptions().position(cuDenver).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)).title("CU Denver"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(cuDenver));

                LatLng cuSprings = new LatLng(38.8965, -104.8061);
                mMap.addMarker(new MarkerOptions().position(cuSprings).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA)).title("CU Colorado Springs"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(cuSprings));

                LatLng mines = new LatLng(39.7510, -105.2226);
                mMap.addMarker(new MarkerOptions().position(mines).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)).title("CU Colorado Springs"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(mines));

                LatLng msu = new LatLng(39.7432, -105.0063);
                mMap.addMarker(new MarkerOptions().position(msu).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)).title("CU Colorado Springs"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(msu));

                LatLng northernColorado = new LatLng(40.4033, -104.7002);
                mMap.addMarker(new MarkerOptions().position(northernColorado).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ROSE)).title("CU Colorado Springs"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(northernColorado));

                LatLng regis = new LatLng(39.7896, -105.0299);
                mMap.addMarker(new MarkerOptions().position(regis).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET)).title("Regis University"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(regis));

                LatLng western = new LatLng(38.5466, -106.9183);
                mMap.addMarker(new MarkerOptions().position(western).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)).title("Western Colorado University"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(western));

                // Move camera to maker
                mMap.moveCamera(CameraUpdateFactory.newLatLng(marker));
                if (zoom == true) {
                    // Animate the zoom in to the marker to a zoom level 10
                    mMap.animateCamera(CameraUpdateFactory.zoomTo(20));
                }
            } else {
                LatLng marker = new LatLng(40.0076, -105.2659);
                mMap.addMarker(new MarkerOptions().position(marker).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)).title("CU Boulder"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(marker));
            }
            }
        });
    }
}