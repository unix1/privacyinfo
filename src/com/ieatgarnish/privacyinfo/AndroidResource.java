package com.ieatgarnish.privacyinfo;

import android.telephony.TelephonyManager;
import android.telephony.CellLocation;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import android.app.ActivityManager;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import java.util.HashMap;
import java.util.Map;

public class AndroidResource
{

	protected TelephonyManager tm;
	protected ActivityManager am;
	protected ConnectivityManager cm;
	protected Context context;
	protected NetworkInfo networkInfoActive;
	protected Map<Integer, String> map_data_activity;
	protected Map<Integer, String> map_data_state;
	protected Map<Integer, String> map_network_type;
	protected Map<Integer, String> map_phone_type;
	protected Map<Integer, String> map_sim_state;

	public AndroidResource(Context context)
	{
		this.setContext(context);
		this.initializeMaps();
	}

	public AndroidResource(Context context, TelephonyManager tm)
	{
		this.setContext(context);
		this.initializeMaps();
		this.setTelephonyManager(tm);
	}

	public AndroidResource(Context context, ActivityManager am)
	{
		this.setContext(context);
		this.initializeMaps();
		this.setActivityManager(am);
	}

	public void setTelephonyManager(TelephonyManager tm)
	{
		this.tm = tm;
	}

	public void setActivityManager(ActivityManager am)
	{
		this.am = am;
	}

	public void setConnectivityManager(ConnectivityManager cm)
	{
		this.cm = cm;
		this.networkInfoActive = this.cm.getActiveNetworkInfo();
	}

	public void setContext(Context context)
	{
		this.context = context;
	}

	protected void initializeMaps()
	{
		this.map_data_activity = new HashMap<Integer, String>();
		this.map_data_state = new HashMap<Integer, String>();
		this.map_network_type = new HashMap<Integer, String>();
		this.map_phone_type = new HashMap<Integer, String>();
		this.map_sim_state = new HashMap<Integer, String>();
		this.setMaps();
	}

	protected void setMaps()
	{
		this.map_data_activity.put(TelephonyManager.DATA_ACTIVITY_DORMANT, context.getString(R.string.tm_DATA_ACTIVITY_DORMANT));
		this.map_data_activity.put(TelephonyManager.DATA_ACTIVITY_IN, context.getString(R.string.tm_DATA_ACTIVITY_IN));
		this.map_data_activity.put(TelephonyManager.DATA_ACTIVITY_INOUT, context.getString(R.string.tm_DATA_ACTIVITY_INOUT));
		this.map_data_activity.put(TelephonyManager.DATA_ACTIVITY_NONE, context.getString(R.string.tm_DATA_ACTIVITY_NONE));
		this.map_data_activity.put(TelephonyManager.DATA_ACTIVITY_OUT, context.getString(R.string.tm_DATA_ACTIVITY_OUT));
		this.map_data_state.put(TelephonyManager.DATA_DISCONNECTED, context.getString(R.string.tm_DATA_DISCONNECTED));
		this.map_data_state.put(TelephonyManager.DATA_CONNECTED, context.getString(R.string.tm_DATA_CONNECTED));
		this.map_data_state.put(TelephonyManager.DATA_CONNECTING, context.getString(R.string.tm_DATA_CONNECTING));
		this.map_data_state.put(TelephonyManager.DATA_SUSPENDED, context.getString(R.string.tm_DATA_SUSPENDED));
		this.map_network_type.put(TelephonyManager.NETWORK_TYPE_1xRTT, context.getString(R.string.tm_NETWORK_TYPE_1xRTT));
		this.map_network_type.put(TelephonyManager.NETWORK_TYPE_CDMA, context.getString(R.string.tm_NETWORK_TYPE_CDMA));
		this.map_network_type.put(TelephonyManager.NETWORK_TYPE_EDGE, context.getString(R.string.tm_NETWORK_TYPE_EDGE));
		this.map_network_type.put(TelephonyManager.NETWORK_TYPE_EHRPD, context.getString(R.string.tm_NETWORK_TYPE_EHRPD));
		this.map_network_type.put(TelephonyManager.NETWORK_TYPE_EVDO_0, context.getString(R.string.tm_NETWORK_TYPE_EVDO_0));
		this.map_network_type.put(TelephonyManager.NETWORK_TYPE_EVDO_A, context.getString(R.string.tm_NETWORK_TYPE_EVDO_A));
		this.map_network_type.put(TelephonyManager.NETWORK_TYPE_EVDO_B, context.getString(R.string.tm_NETWORK_TYPE_EVDO_B));
		this.map_network_type.put(TelephonyManager.NETWORK_TYPE_GPRS, context.getString(R.string.tm_NETWORK_TYPE_GPRS));
		this.map_network_type.put(TelephonyManager.NETWORK_TYPE_HSDPA, context.getString(R.string.tm_NETWORK_TYPE_HSDPA));
		this.map_network_type.put(TelephonyManager.NETWORK_TYPE_HSPA, context.getString(R.string.tm_NETWORK_TYPE_HSPA));
		this.map_network_type.put(TelephonyManager.NETWORK_TYPE_HSPAP, context.getString(R.string.tm_NETWORK_TYPE_HSPAP));
		this.map_network_type.put(TelephonyManager.NETWORK_TYPE_HSUPA, context.getString(R.string.tm_NETWORK_TYPE_HSUPA));
		this.map_network_type.put(TelephonyManager.NETWORK_TYPE_IDEN, context.getString(R.string.tm_NETWORK_TYPE_IDEN));
		this.map_network_type.put(TelephonyManager.NETWORK_TYPE_LTE, context.getString(R.string.tm_NETWORK_TYPE_LTE));
		this.map_network_type.put(TelephonyManager.NETWORK_TYPE_UMTS, context.getString(R.string.tm_NETWORK_TYPE_UMTS));
		this.map_network_type.put(TelephonyManager.NETWORK_TYPE_UNKNOWN, context.getString(R.string.tm_NETWORK_TYPE_UNKNOWN));
		this.map_phone_type.put(TelephonyManager.PHONE_TYPE_CDMA, context.getString(R.string.tm_PHONE_TYPE_CDMA));
		this.map_phone_type.put(TelephonyManager.PHONE_TYPE_GSM, context.getString(R.string.tm_PHONE_TYPE_GSM));
		this.map_phone_type.put(TelephonyManager.PHONE_TYPE_NONE, context.getString(R.string.tm_PHONE_TYPE_NONE));
		this.map_sim_state.put(TelephonyManager.SIM_STATE_ABSENT, context.getString(R.string.tm_SIM_STATE_ABSENT));
		this.map_sim_state.put(TelephonyManager.SIM_STATE_NETWORK_LOCKED, context.getString(R.string.tm_SIM_STATE_NETWORK_LOCKED));
		this.map_sim_state.put(TelephonyManager.SIM_STATE_PIN_REQUIRED, context.getString(R.string.tm_SIM_STATE_PIN_REQUIRED));
		this.map_sim_state.put(TelephonyManager.SIM_STATE_PUK_REQUIRED, context.getString(R.string.tm_SIM_STATE_PUK_REQUIRED));
		this.map_sim_state.put(TelephonyManager.SIM_STATE_READY, context.getString(R.string.tm_SIM_STATE_READY));
		this.map_sim_state.put(TelephonyManager.SIM_STATE_UNKNOWN, context.getString(R.string.tm_SIM_STATE_UNKNOWN));
	}


	public String getTelephonyCallState()
	{
		///NOTE: No permissions
		return Integer.toString(tm.getCallState());
	}

	public String getTelephonyCellLocation()
	{
		///NOTE: Requires Permission: ACCESS_COARSE_LOCATION or ACCESS_FINE_LOCATION
		if (tm.getCellLocation() == null) return context.getString(R.string.unavailable);
		else return tm.getCellLocation().toString();
	}

	public String getTelephonyCellId()
	{
		///NOTE: Requires Permission: ACCESS_COARSE_LOCATION
		String result;
		CellLocation cl = (CellLocation) tm.getCellLocation();
		if (cl instanceof CdmaCellLocation) {
			result = String.valueOf(((CdmaCellLocation) cl).getBaseStationId());
		} else if (cl instanceof GsmCellLocation) {
			result = String.valueOf(((GsmCellLocation) cl).getCid());
		}
		else result = context.getString(R.string.unavailable);
		return result;
	}

	public String getTelephonyDataActivity()
	{
		///NOTE: No permissions
		return this.map_data_activity.get(tm.getDataActivity());
	}

	public String getTelephonyDataState()
	{
		///NOTE: No permissions
		return this.map_data_state.get(tm.getDataState());
	}

	public String getTelephonyDeviceId()
	{
		///NOTE: Requires Permission: READ_PHONE_STATE
		if (tm.getDeviceId() == null) return context.getString(R.string.unavailable);
		else return tm.getDeviceId();
	}

	public String getTelephonyDeviceSoftwareVersion()
	{
		///NOTE: Requires Permission: READ_PHONE_STATE
		if (tm.getDeviceSoftwareVersion() == null) return context.getString(R.string.unavailable);
		else return tm.getDeviceSoftwareVersion();
	}

	public String getTelephonyLine1Number()
	{
		///NOTE: Requires Permission: READ_PHONE_STATE
		if (tm.getLine1Number() == null) return context.getString(R.string.unavailable);
		else return tm.getLine1Number();
	}

	public String getTelephonyNeighboringCellInfo()
	{
		///NOTE: Requires Permission: ACCESS_COARSE_UPDATES
		return tm.getNeighboringCellInfo().toString();
	}

	public String getTelephonyNetworkCountryIso()
	{
		///NOTE: No permissions
		return tm.getNetworkCountryIso();
	}

	public String getTelephonyNetworkOperator()
	{
		///NOTE: No permissions
		return tm.getNetworkOperator();
	}

	public String getTelephonyNetworkOperatorName()
	{
		///NOTE: No permissions
		return tm.getNetworkOperatorName();
	}

	public String getTelephonyNetworkType()
	{
		///NOTE: No permissions
		return this.map_network_type.get(tm.getNetworkType());
	}

	public String getTelephonyPhoneType()
	{
		///NOTE: No permissions
		return this.map_phone_type.get(tm.getPhoneType());
	}

	public String getTelephonySimCountryIso()
	{
		///NOTE: No permissions
		return tm.getSimCountryIso();
	}

	public String getTelephonySimOperator()
	{
		///NOTE: No permissions
		if (tm.getSimState() == TelephonyManager.SIM_STATE_READY) return tm.getSimOperator();
		else return context.getString(R.string.unknown_sim_not_ready);
	}

	public String getTelephonySimOperatorName()
	{
		///NOTE: No permissions
		if (tm.getSimState() == TelephonyManager.SIM_STATE_READY) return tm.getSimOperatorName();
		else return context.getString(R.string.unknown_sim_not_ready);
	}

	public String getTelephonySimSerialNumber()
	{
		///NOTE: Requires Permission: READ_PHONE_STATE
		if (tm.getSimSerialNumber() == null) return context.getString(R.string.unavailable);
		else return tm.getSimSerialNumber();
	}

	public String getTelephonySimState()
	{
		///NOTE: No permissions
		return this.map_sim_state.get(tm.getSimState());
	}

	public String getTelephonySubscriberId()
	{
		///NOTE: Requires Permission: READ_PHONE_STATE
		if (tm.getSubscriberId() == null) return context.getString(R.string.unavailable);
		else return tm.getSubscriberId();
	}

	public String getTelephonyVoiceMailAlphaTag()
	{
		///NOTE: Requires Permission: READ_PHONE_STATE
		return tm.getVoiceMailAlphaTag();
	}

	public String getTelephonyVoiceMailNumber()
	{
		///NOTE: Requires Permission: READ_PHONE_STATE
		if (tm.getVoiceMailNumber() == null) return context.getString(R.string.unavailable);
		else return tm.getVoiceMailNumber();
	}

	public String getTelephonyHasIccCard()
	{
		///NOTE: No permissions
		if (tm.hasIccCard()) return context.getString(R.string.yes);
		else return context.getString(R.string.no);
	}

	public String getTelephonyIsNetworkRoaming()
	{
		///NOTE: No permissions
		if (tm.isNetworkRoaming()) return context.getString(R.string.yes);
		else return context.getString(R.string.no);
	}

	public String getActivityMemoryClass()
	{
		///NOTE: No permissions
		return Integer.toString(am.getMemoryClass());
	}

	public String getConnectivityNetworkInfoTypeName()
	{
		///NOTE: No permissions
		return networkInfoActive.getTypeName();
	}

	public String getConnectivityNetworkInfoSubTypeName()
	{
		///NOTE: No permissions
		return networkInfoActive.getSubtypeName();
	}

}
