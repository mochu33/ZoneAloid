package org.zonealoid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ZoneAloid extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		OnClickListener buttonStartServiceListener = new OnClickListener() {
			public void onClick(View v) {
				startService(new Intent(ZoneAloid.this, LocationService.class));
				Log.d("ZoneAloid", "click start");
			}
		};

		OnClickListener buttonStopServiceListener = new OnClickListener() {
			public void onClick(View v) {
				stopService(new Intent(ZoneAloid.this, LocationService.class));
				Log.d("ZoneAloid", "click stop");
			}
		};

		((Button) findViewById(R.id.ButtonStartService)).setOnClickListener(buttonStartServiceListener);
		((Button) findViewById(R.id.ButtonStopService)).setOnClickListener(buttonStopServiceListener);


	}
}
