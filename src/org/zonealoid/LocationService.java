package org.zonealoid;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class LocationService extends Service{

	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void onCreate() {
		// se ejecuta solo al crear, no cada vez que se llama a startService
		Toast.makeText(this, "My Service Created", Toast.LENGTH_LONG).show();
		Log.d("ZoneAloid", "service created");

	}

	@Override
	public void onStart(Intent intent, int startid){
		// se ejecuta cada vez que se llama a startService aunque este creado
		Toast.makeText(this, "My Service Started", Toast.LENGTH_LONG).show();
		Log.d("ZoneAloid", "service start");
	}

	@Override
	public void onDestroy() {
		Toast.makeText(this, "My Service Stopped", Toast.LENGTH_LONG).show();
		Log.d("ZoneAloid", "service stopped");
	}

}
