package org.zonealoid;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class LocationService extends Service{

	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	private LocationManager locationManager;
	private ZoneAloidLocationListener locationListener;

	@Override
	public void onCreate() {
		// se ejecuta solo al crear, no cada vez que se llama a startService
		Toast.makeText(this, "My Service Created", Toast.LENGTH_LONG).show();
		Log.d("ZoneAloid", "service created");

		// Acquire a reference to the system Location Manager
		this.locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
		// Define a listener that responds to location updates
		this.locationListener = new ZoneAloidLocationListener();

		// Register the listener with the Location Manager to receive location updates
		this.locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, ZoneAloidLocationListener.MIN_TIME, ZoneAloidLocationListener.MIN_DISTANCE, this.locationListener);
		// Or, use GPS location data:
		// From google doc: You can also request location updates from both the GPS and the Network Location Provider by calling requestLocationUpdates() twice
		this.locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,ZoneAloidLocationListener.MIN_TIME, ZoneAloidLocationListener.MIN_DISTANCE, this.locationListener);

	}

	@Override
	public void onStart(Intent intent, int startid){
		// se ejecuta cada vez que se llama a startService aunque este creado
		Log.d("ZoneAloid", "service start");
	}

	@Override
	public void onDestroy() {
		Toast.makeText(this, "My Service Stopped", Toast.LENGTH_LONG).show();
		Log.d("ZoneAloid", "service stopped");

		// Remove the listener you previously added
		this.locationManager.removeUpdates(this.locationListener);
	}

}
