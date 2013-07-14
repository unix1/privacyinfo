package com.ieatgarnish.privacyinfo;

import android.app.Activity;
import android.telephony.TelephonyManager;
import android.os.Bundle;
import android.widget.TextView;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class ActivityReadPhoneState extends Activity
{

	protected AndroidResource resource;
	protected Map<Integer, String> mapViews;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.read_phone_state);
		resource = new AndroidResource(this, (TelephonyManager) this.getSystemService(TELEPHONY_SERVICE));
		this.mapViews = new HashMap<Integer, String>();
		this.initializeViewMap();
		this.displayViewMap();
	}

	public void initializeViewMap()
	{
		mapViews.put(R.id.line1_number, resource.getTelephonyLine1Number());
		//mapViews.put(R.id.cell_location, resource.getTelephonyCellLocation());
		mapViews.put(R.id.device_id, resource.getTelephonyDeviceId());
		mapViews.put(R.id.device_software_version, resource.getTelephonyDeviceSoftwareVersion());
		mapViews.put(R.id.sim_serial_number, resource.getTelephonySimSerialNumber());
		mapViews.put(R.id.subscriber_id, resource.getTelephonySubscriberId());
		mapViews.put(R.id.voicemail_alpha_tag, resource.getTelephonyVoiceMailAlphaTag());
		mapViews.put(R.id.voicemail_number, resource.getTelephonyVoiceMailNumber());
	}

	public void displayViewMap()
	{
		Iterator<Entry<Integer, String>> it = mapViews.entrySet().iterator();
		while (it.hasNext())
		{
			Entry<Integer, String> pairs = it.next();
			((TextView) this.findViewById(pairs.getKey())).setText(
				String.format(
					(String)((TextView) this.findViewById(pairs.getKey())).getText(),
					pairs.getValue()
				)
			);
		}
	}

}
