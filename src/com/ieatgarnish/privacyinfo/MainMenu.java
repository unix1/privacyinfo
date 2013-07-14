package com.ieatgarnish.privacyinfo;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TabHost;
import android.widget.Button;

public class MainMenu extends TabActivity
{
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		TabHost mTabHost = getTabHost();
		mTabHost.addTab(mTabHost.newTabSpec("tab_permissions").setIndicator("Permissions").setContent(R.id.tab_permissions));
		mTabHost.setCurrentTab(0);
		Button button_no_perms = (Button) this.findViewById(R.id.button_no_perms);
		button_no_perms.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				// handle click
				Intent intent = new Intent(Intent.ACTION_VIEW);
				intent.setClassName(getApplicationContext(), ActivityNoPermissions.class.getName());
				startActivity(intent);
			}
		});
		Button button_read_phone_state = (Button) this.findViewById(R.id.button_read_phone_state);
		button_read_phone_state.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				// handle click
				Intent intent = new Intent(Intent.ACTION_VIEW);
				intent.setClassName(getApplicationContext(), ActivityReadPhoneState.class.getName());
				startActivity(intent);
			}
		});
		Button button_access_network_state = (Button) this.findViewById(R.id.button_access_network_state);
		button_access_network_state.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				// handle click
				Intent intent = new Intent(Intent.ACTION_VIEW);
				intent.setClassName(getApplicationContext(), ActivityAccessNetworkState.class.getName());
				startActivity(intent);
			}
		});
		Button button_access_coarse_location = (Button) this.findViewById(R.id.button_access_coarse_location);
		button_access_coarse_location.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				// handle click
				Intent intent = new Intent(Intent.ACTION_VIEW);
				intent.setClassName(getApplicationContext(), ActivityAccessCoarseLocation.class.getName());
				startActivity(intent);
			}
		});
	}
}