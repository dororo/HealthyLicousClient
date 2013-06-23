package com.eis.healthylicous;

import org.jivesoftware.smack.XMPPException;

import com.eis.healthylicous.communication.DataHandler;
import com.eis.healthylicous.communication.GoogleMapsAPI;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Strecken extends Activity {
	
	Button btn_sim;
//	Button sf_multimedia_bilder_laden;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.strecken);
			
		btn_sim = (Button) findViewById(R.id.btn_sim);
		
		// dummi
		btn_sim.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
	
				//simmulation einf�gen
				btn_sim.setText("pub Kalorien");
				btn_sim.setEnabled(false);
				
				Integer calo = 100;
				
				try {
					MainActivity.connection.publishPayload("Kalories", new DataHandler().setKalories(calo.toString(), MainActivity.connection.getUser()));
					Log.d("HEALTHYCONTROLLER", "Set Kalories succeeded");

//					blbl.setText(MainActivity.connection.getUser());
				} catch (XMPPException e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	//Button der auf die GoogleMaps Seite zugreift
	 public void onNavButtonClick(final View view) {
//	    	Intent intent = null;
		switch (view.getId()) {
		case R.id.sf_aussenwelt_google_maps:
			startActivity(new Intent(this, GoogleMapsAPI.class));
			break;
//		case R.id.sf_intents_karte:
//    		try {
//    		intent = new Intent(Intent.ACTION_VIEW,
//    				Uri.parse("geo:50.94117,6.95696?z=16"));
//    		startActivity(intent);
//    		} catch (Exception e) {}
//    		break; 				
		} 	
	}
}







