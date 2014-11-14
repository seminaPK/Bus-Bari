package com.example.hackatonmhoo14;

import android.app.Activity;
import android.location.Location;
import android.os.Bundle;
import android.widget.EditText;

import com.example.busbari.R;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.location.LocationClient;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;

public class MainActivity extends Activity implements
				GooglePlayServicesClient.ConnectionCallbacks,
				GooglePlayServicesClient.OnConnectionFailedListener {
	
	private GoogleMap mMap;
	private LocationClient mLocationClient;
	public Double lat, lng;

    @Override
    protected void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
                
        setContentView(R.layout.activity_main);       
        
        mMap = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
        mMap.setMyLocationEnabled(true);
        
        mLocationClient = new LocationClient(this, this, this);        
    }
    
    @Override
    protected void onStart() {
    	// TODO Auto-generated method stub
    	super.onStart();
    	mLocationClient.connect();
    }
    
    @Override
    protected void onStop() {
    	// TODO Auto-generated method stub
    	mLocationClient.disconnect();
    	super.onStop();
    }
    
    @Override
    public void onConnected(Bundle arg0) {
    	// TODO Auto-generated method stub
    	Location partenza;
    	partenza = mLocationClient.getLastLocation();
    	
    	lat = partenza.getLatitude();
    	lng = partenza.getLongitude();
    	
    	    	
    }
    
    @Override
    public void onDisconnected() {
    	// TODO Auto-generated method stub
    	
    }
    
    @Override
    public void onConnectionFailed(ConnectionResult arg0) {
    	// TODO Auto-generated method stub
    	
    }
}
