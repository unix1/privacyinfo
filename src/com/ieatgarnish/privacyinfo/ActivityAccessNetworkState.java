package com.ieatgarnish.privacyinfo;

import android.app.Activity;
import android.os.Bundle;
import android.net.ConnectivityManager;
import android.widget.TextView;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class ActivityAccessNetworkState extends Activity
{

	protected AndroidResource resource;
	protected Map<Integer, String> mapViews;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.access_network_state);
		resource = new AndroidResource(this);
		resource.setConnectivityManager((ConnectivityManager) this.getSystemService(CONNECTIVITY_SERVICE));
		this.mapViews = new HashMap<Integer, String>();
		this.initializeViewMap();
		this.displayViewMap();
	}

	public void initializeViewMap()
	{
		mapViews.put(R.id.cm_network_info_type_name, resource.getConnectivityNetworkInfoTypeName());
		mapViews.put(R.id.cm_network_info_subtype_name, resource.getConnectivityNetworkInfoSubTypeName());
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
