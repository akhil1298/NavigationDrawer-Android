package com.akhilbatlawala.navigationdrawer;

import java.util.ArrayList;
import java.util.List;
import com.example.navigationdrawer.R;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

@SuppressLint("NewApi")
public class NavigationMainActivity extends Activity {

	ListView listview;
	List<DrawerItem> dataList;
	
	DrawerLayout drawerlayout;
	ActionBarDrawerToggle actionbarDrawerToggle;
	
	CharSequence mTitle;
	CharSequence mDrawerTitle;
	
	DrawerAdapter drawerAdapter;
	
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.navigation_main);
	
		dataList = new ArrayList<DrawerItem>();
		listview = (ListView)findViewById(R.id.left_drawer);
		
		drawerlayout = (DrawerLayout)findViewById(R.id.drawerlayout);
		
		dataList.add(new DrawerItem("Message", R.drawable.ic_launcher));
		dataList.add(new DrawerItem("Likes", R.drawable.ic_launcher));
		dataList.add(new DrawerItem("Games", R.drawable.ic_launcher));
		dataList.add(new DrawerItem("Lables", R.drawable.ic_launcher));
		dataList.add(new DrawerItem("Search", R.drawable.ic_launcher));
		dataList.add(new DrawerItem("Cloud", R.drawable.ic_launcher));
		dataList.add(new DrawerItem("Camara", R.drawable.ic_launcher));
		dataList.add(new DrawerItem("Video", R.drawable.ic_launcher));
		dataList.add(new DrawerItem("Groups", R.drawable.ic_launcher));
		dataList.add(new DrawerItem("Import & Export",R.drawable.ic_launcher));
		dataList.add(new DrawerItem("About", R.drawable.ic_launcher));
		dataList.add(new DrawerItem("Settings", R.drawable.ic_launcher));
		dataList.add(new DrawerItem("Help", R.drawable.ic_launcher));
		
		drawerAdapter = new DrawerAdapter(this, dataList);
		
		listview.setAdapter(drawerAdapter);
		listview.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				SelectItem(arg2);
			}
		});
		
		getActionBar().setDisplayHomeAsUpEnabled(true);
		getActionBar().setHomeButtonEnabled(true);
		
		actionbarDrawerToggle = new ActionBarDrawerToggle(this, drawerlayout, R.drawable.ic_launcher,
				R.drawable.ic_launcher, R.drawable.ic_launcher){

					@Override
					public void onDrawerClosed(View drawerView) {
						super.onDrawerClosed(drawerView);
						getActionBar().setTitle(mTitle);
						invalidateOptionsMenu();
					}

					@Override
					public void onDrawerOpened(View drawerView) {
						super.onDrawerOpened(drawerView);
						getActionBar().setTitle(mDrawerTitle);
						invalidateOptionsMenu();
					}
		};
		
		drawerlayout.setDrawerListener(actionbarDrawerToggle);
		
		if (savedInstanceState == null) {
			SelectItem(0);
		}
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	
		if(actionbarDrawerToggle.onOptionsItemSelected(item))
			return true;
		
		return false;
	}

	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	@SuppressLint("NewApi")
	public void SelectItem(int possition) {

		Fragment fragment = null;
		
		switch (possition) {
		case 0:
			fragment = new FragmentOne();
			
			break;
		case 1:
			fragment = new FragmentTwo();
			break;
		case 2:
			fragment = new FragmentThree();
			break;
		case 3:
			fragment = new FragmentOne();
			break;
		case 4:
			fragment = new FragmentTwo();
			break;
		case 5:
			fragment = new FragmentThree();
			break;
		
		default:
			break;
		}

		FragmentManager frgManager = getFragmentManager();
		frgManager.beginTransaction().replace(R.id.content_frame, fragment)
				.commit();

		listview.setItemChecked(possition, true);
		setTitle(dataList.get(possition).getName());
		drawerlayout.closeDrawer(listview);
	}
	
	@Override
	public void setTitle(CharSequence title) {
		mTitle = title;
		getActionBar().setTitle(mTitle);
	}
	
}
