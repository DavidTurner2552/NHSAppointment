package com.example.david.nhsappointment;

import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.location.LocationServices;

import static android.Manifest.permission.ACCESS_FINE_LOCATION;

public class MapsActivity extends FragmentActivity implements
        OnMapReadyCallback,
        GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener,
        GoogleMap.OnMarkerDragListener,
        GoogleMap.OnMapLongClickListener,
        View.OnClickListener {

    private int PROXIMITY_RADIUS = 10000;
    private GoogleMap mMap;

    private double longitude;
    private double latitude;
    private String location = latitude + ", " + longitude;

    private ImageButton home;
    private ImageButton current;
    private ImageButton personal;
    private ImageButton closest;

    private GoogleApiClient googleApiClient;
    private FusedLocationProviderClient mFusedLocationClient;

    private static final LatLng PERSONAL = new LatLng(53.6446316,-1.7510254999999688);
    private Marker mPersonal;
    private static final LatLng CLOSEST = new LatLng(53.6438703, -1.775459899999987);
    private Marker mClosest;
    private int personalCount = 0;
    private int closestCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        //Initializing googleapi client
        googleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();

        //Initializing views and adding onclick listeners
        personal = (ImageButton) findViewById(R.id.personal_button);
        current = (ImageButton) findViewById(R.id.current_button);
        closest = (ImageButton) findViewById(R.id.closest_button);
        home = (ImageButton) findViewById(R.id.home_button);
        personal.setOnClickListener(this);
        current.setOnClickListener(this);
        closest.setOnClickListener(this);
        home.setOnClickListener(this);
    }

    @Override
    protected void onStart() {
        googleApiClient.connect();
        super.onStart();
    }

    @Override
    protected void onStop() {
        googleApiClient.disconnect();
        super.onStop();
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        //Initializing our map
        mMap = googleMap;
        //Creating a random coordinate
        LatLng latLng = new LatLng(53.64358170000001, -1.7785036999999875);
        //Adding marker to that coordinate
        mMap.addMarker(new MarkerOptions().position(latLng).draggable(true));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        float zoomLevel = 15.0f; //This goes up to 21
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, zoomLevel));
        //Setting onMarkerDragListener to track the marker drag
        mMap.setOnMarkerDragListener(this);
        //Adding a long click listener to the map
        mMap.setOnMapLongClickListener(this);
    }

    //Getting current location
    private void getCurrentLocation() {
        //Creating a location object
//        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
//            return;
//        }
//
//        mFusedLocationClient.getLastLocation()
//                .addOnSuccessListener(this, new OnSuccessListener<Location>() {
//                    @Override
//                    public void onSuccess(Location location) {
//                        // Got last known location. In some rare situations this can be null.
//                        if (location != null) {
//                            longitude = location.getLongitude();
//                            latitude = location.getLatitude();
//
//                            //moving the map to location
//                            moveMap();
//                        }
//                        moveMap();
//                    }
//                });
    }

    private void requestPermission(){
        ActivityCompat.requestPermissions(this, new String[]{ACCESS_FINE_LOCATION}, 1);
        }
    //Function to move the map
    private void moveMap() {
        //String to display current latitude and longitude
        String msg = "Huddersfield University";

        //Creating a LatLng Object to store Coordinates
        LatLng latLng = new LatLng(latitude, longitude);

        //Adding marker to map
        mMap.addMarker(new MarkerOptions()
                .position(latLng) //setting position
                .draggable(true) //Making the marker draggable
                .title("Current Location")); //Adding a title

        //Moving the camera
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));

        //Animating the camera
        mMap.animateCamera(CameraUpdateFactory.zoomTo(15));

        //Displaying current coordinates in toast
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(View v) {
        String Restaurant = "restaurant";
        if(v == current){
           // getCurrentLocation();
            latitude = 53.64358170000001;
            longitude = -1.7785036999999875;
            moveMap();
        }
        else if (v == home){
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
        }
        else if(v == closest){
            mClosest = mMap.addMarker(new MarkerOptions()
                    .position(CLOSEST)
                    .title("Closest"));
            mClosest.setTag(0);
            closestCount++;
            if (personalCount == 1){
            mPersonal.remove();
            personalCount--;}
            String mapMsg = "The closest surgery to your location is the Universty Health Center";
            Toast.makeText(this, mapMsg, Toast.LENGTH_LONG).show();
        }
        else if(v == personal){
            mPersonal = mMap.addMarker(new MarkerOptions()
                    .position(PERSONAL)
                    .title("Personal"));
            mPersonal.setTag(0);
            mMap.animateCamera(CameraUpdateFactory.zoomTo(13));
            personalCount++;
            if (closestCount == 1){
                mClosest.remove();
                closestCount--;}
            String mapMsg = "The surgery you're registered with is Dalton Surgery";
            Toast.makeText(this, mapMsg, Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onConnected(Bundle bundle) {
        getCurrentLocation();
    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {

    }

    @Override
    public void onMapLongClick(LatLng latLng) {
        //Clearing all the markers
        mMap.clear();

        //Adding a new marker to the current pressed position we are also making the draggable true
        mMap.addMarker(new MarkerOptions()
                .position(latLng)
                .draggable(true));
    }

    @Override
    public void onMarkerDragStart(Marker marker) {

    }

    @Override
    public void onMarkerDrag(Marker marker) {

    }

    @Override
    public void onMarkerDragEnd(Marker marker) {
        //Getting the coordinates
        latitude = marker.getPosition().latitude;
        longitude = marker.getPosition().longitude;

        //Moving the map
        moveMap();
    }

    private String getUrl(double latitude, double longitude, String nearbyPlace) {

        StringBuilder googlePlacesUrl = new StringBuilder("https://maps.googleapis.com/maps/api/place/nearbysearch/json?");
        googlePlacesUrl.append("location=" + latitude + "," + longitude);
        googlePlacesUrl.append("&radius=" + PROXIMITY_RADIUS);
        googlePlacesUrl.append("&type=" + nearbyPlace);
        googlePlacesUrl.append("&sensor=true");
        googlePlacesUrl.append("&key=" + "AIzaSyATuUiZUkEc_UgHuqsBJa1oqaODI-3mLs0");
        Log.d("getUrl", googlePlacesUrl.toString());
        return (googlePlacesUrl.toString());
    }
}
