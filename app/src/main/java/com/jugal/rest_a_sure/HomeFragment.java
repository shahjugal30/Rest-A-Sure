package com.jugal.rest_a_sure;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.wrappers.PackageManagerWrapper;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

import static com.firebase.ui.auth.AuthUI.getApplicationContext;

public class HomeFragment extends Fragment implements
        OnMapReadyCallback,
        GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener,
        LocationListener
{
    SupportMapFragment mapFragment;
    private GoogleMap mMap;
    private GoogleApiClient googleApiClient;
    private LocationRequest locationRequest;
    private Location lastLocation;
    private Marker currentUserLocationMarker;
    private static final int Request_User_Location_Code = 101;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
        {
            checkUserLocationPermission();
        }
        mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        if (mapFragment == null)
        {
            FragmentManager fm = getFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            mapFragment = SupportMapFragment.newInstance();
            ft.replace(R.id.map, mapFragment).commit();
        }
        mapFragment.getMapAsync(this);
        return view;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

    mMap = googleMap;
        LatLng grandmama = new LatLng(19.091418,72.827888);
        mMap.addMarker(new MarkerOptions().position(grandmama).title("Grandmama's All Day Cafe"));

        LatLng mehman = new LatLng(19.111687,72.909188);
        mMap.addMarker(new MarkerOptions().position(mehman).title("Mehman Nawazi"));

        LatLng ftabove = new LatLng(19.228485,72.852599);
        mMap.addMarker(new MarkerOptions().position(ftabove).title("90FT ABOVE"));

        LatLng aroundglobe = new LatLng(19.223664,72.841122);
        mMap.addMarker(new MarkerOptions().position(aroundglobe).title("AROUND D’GLOBE"));

        LatLng kailash = new LatLng(19.202992,72.859805);
        mMap.addMarker(new MarkerOptions().position(kailash).title("KAILASH PARBAT"));

        LatLng mastee = new LatLng(19.223667,72.841146);
        mMap.addMarker(new MarkerOptions().position(mastee).title("MASTEE"));

        LatLng theobroma = new LatLng(19.220825,72.851322);
        mMap.addMarker(new MarkerOptions().position(theobroma).title("THEOBROMA"));

        LatLng hydro = new LatLng(19.221023,72.862200);
        mMap.addMarker(new MarkerOptions().position(hydro).title("CAFÉ HYDRO"));

        LatLng brainfreeze = new LatLng(19.103534,72.852171);
        mMap.addMarker(new MarkerOptions().position(brainfreeze).title("BRAIN FREEZE ICE CREAM & DESERTS"));

        LatLng bombay_kulfi = new LatLng(19.236916,72.853708);
        mMap.addMarker(new MarkerOptions().position(bombay_kulfi).title("Bombay Kulfi"));

        LatLng messy_house = new LatLng(19.211703,72.841306);
        mMap.addMarker(new MarkerOptions().position(messy_house).title("The Messy House - Dessert Bar & Cafe"));

        LatLng chocolate_heaven = new LatLng(19.104267,72.836623);
        mMap.addMarker(new MarkerOptions().position(chocolate_heaven).title("The Chocolate Heaven"));

        LatLng huber_holly = new LatLng(19.099002,72.827315);
        mMap.addMarker(new MarkerOptions().position(huber_holly).title("Huber & Holly – Juhu Tara Road, Mumbai"));

        LatLng banana_leaf = new LatLng(19.125101,72.822510);
        mMap.addMarker(new MarkerOptions().position(banana_leaf).title("Banana Leaf Restaurant"));

        LatLng barbeque_nation = new LatLng(19.136227,72.833212);
        mMap.addMarker(new MarkerOptions().position(barbeque_nation).title("Barbeque Nation - Mumbai - Lokhandwala"));

        LatLng shreeji = new LatLng(19.234338,72.855702);
        mMap.addMarker(new MarkerOptions().position(shreeji).title("Shreeji's The Fusion Kitchen"));

        LatLng girgaon = new LatLng(19.230737,72.852265);
        mMap.addMarker(new MarkerOptions().position(girgaon).title("Girgaon Katta"));

        LatLng bbc = new LatLng(19.229925,72.847892);
        mMap.addMarker(new MarkerOptions().position(bbc).title("Biryani Barbeque Chinese"));

        LatLng pangat = new LatLng(19.231093,72.836901);
        mMap.addMarker(new MarkerOptions().position(pangat).title("Pangat"));

        LatLng bhagat = new LatLng(19.224351,72.851541);
        mMap.addMarker(new MarkerOptions().position(bhagat).title("K Bhagat Tarachand"));

        LatLng fusion = new LatLng(19.254638,72.849076);
        mMap.addMarker(new MarkerOptions().position(fusion).title("The Fusion Kitchen"));

        LatLng burgerking = new LatLng(19.141613,72.830938);
        mMap.addMarker(new MarkerOptions().position(burgerking).title("Burger King"));

        LatLng mcdonalds = new LatLng(19.119613,72.846057);
        mMap.addMarker(new MarkerOptions().position(mcdonalds).title("McDonald's"));

        LatLng maharajabhog = new LatLng(19.096409,72.828140);
        mMap.addMarker(new MarkerOptions().position(maharajabhog).title("Maharaja Bhog"));



        if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED)
        {



             buildGoogleApiClient();

             mMap.setMyLocationEnabled(true);
        }

    }

    public boolean checkUserLocationPermission()
    {
        if (ContextCompat.checkSelfPermission(getContext(),Manifest.permission.ACCESS_FINE_LOCATION) !=PackageManager.PERMISSION_GRANTED)
        {
            if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(),Manifest.permission.ACCESS_FINE_LOCATION))
            {
                ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.ACCESS_FINE_LOCATION},Request_User_Location_Code);
            }
            else
            {
                ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.ACCESS_FINE_LOCATION},Request_User_Location_Code);
            }
            return false;
        }
        else
        {
            return true;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults)
    {
        switch (requestCode)
        {
            case Request_User_Location_Code:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                {
                    if (ContextCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED)
                    {
                        if (googleApiClient == null)
                        {
                            buildGoogleApiClient();
                        }
                        mMap.setMyLocationEnabled(true);
                    }
                }
                else
                {
                    Toast.makeText(getContext(),"Permission Denied....",Toast.LENGTH_SHORT).show();
                }
                return;
        }
    }

    protected synchronized void buildGoogleApiClient()
    {
        googleApiClient = new GoogleApiClient.Builder(getContext())
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();
        googleApiClient.connect();
    }

    @Override
    public void onLocationChanged(Location location) {
        lastLocation = location;

        if(currentUserLocationMarker != null)
        {
            currentUserLocationMarker.remove();
        }

        LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());

        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(11));
        if (googleApiClient != null)
        {
            LocationServices.FusedLocationApi.removeLocationUpdates(googleApiClient, this);
        }

    }



    @Override
    public void onConnected(@Nullable Bundle bundle) {

        locationRequest =  new LocationRequest();
        locationRequest.setInterval(1);
        locationRequest.setFastestInterval(1);
        locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);

        if (ContextCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED)
        {
            LocationServices.FusedLocationApi.requestLocationUpdates(googleApiClient, locationRequest,this);
        }


    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }
}
