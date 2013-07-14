package com.ieatgarnish.privacyinfo;

import android.app.TabActivity;
import android.telephony.TelephonyManager;
import android.app.ActivityManager;
//import android.net.ConnectivityManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.TabHost;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;


public class ActivityNoPermissions extends TabActivity
{

	protected AndroidResource resource;
	protected Map<Integer, String> mapViews;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.no_permissions);
		TabHost mTabHost = getTabHost();
		mTabHost.addTab(mTabHost.newTabSpec("tab_telephony").setIndicator("Telephony").setContent(R.id.tab_telephony));
		mTabHost.addTab(mTabHost.newTabSpec("tab_other").setIndicator("Other").setContent(R.id.tab_other));
		mTabHost.setCurrentTab(0);
		resource = new AndroidResource(this);
		resource.setTelephonyManager((TelephonyManager) this.getSystemService(TELEPHONY_SERVICE));
		resource.setActivityManager((ActivityManager) this.getSystemService(ACTIVITY_SERVICE));
		//resource.setConnectivityManager((ConnectivityManager) this.getSystemService(CONNECTIVITY_SERVICE));
		this.mapViews = new HashMap<Integer, String>();
		this.initializeViewMap();
		this.displayViewMap();
	}

	public void initializeViewMap()
	{
		mapViews.put(R.id.call_state, resource.getTelephonyCallState());
		mapViews.put(R.id.data_activity, resource.getTelephonyDataActivity());
		mapViews.put(R.id.data_state, resource.getTelephonyDataState());
		mapViews.put(R.id.network_country_iso, resource.getTelephonyNetworkCountryIso());
		mapViews.put(R.id.network_operator, resource.getTelephonyNetworkOperator());
		mapViews.put(R.id.network_operator_name, resource.getTelephonyNetworkOperatorName());
		mapViews.put(R.id.network_type, resource.getTelephonyNetworkType());
		mapViews.put(R.id.phone_type, resource.getTelephonyPhoneType());
		mapViews.put(R.id.sim_country_iso, resource.getTelephonySimCountryIso());
		mapViews.put(R.id.sim_operator, resource.getTelephonySimOperator());
		mapViews.put(R.id.sim_operator_name, resource.getTelephonySimOperatorName());
		mapViews.put(R.id.sim_state, resource.getTelephonySimState());
		mapViews.put(R.id.has_icc_card, resource.getTelephonyHasIccCard());
		mapViews.put(R.id.is_network_roaming, resource.getTelephonyIsNetworkRoaming());
		mapViews.put(R.id.am_memory_class, resource.getActivityMemoryClass());
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
