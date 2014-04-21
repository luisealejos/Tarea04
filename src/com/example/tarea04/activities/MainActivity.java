package com.example.tarea04.activities;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.tarea04.R;
import com.example.tarea04.fragments.ComunityFragment;
import com.example.tarea04.fragments.ListStoreFragment;
import com.example.tarea04.fragments.ViewPagerImageFragment;
import com.example.tarea04.fragments.PhotoDialogFragment.NoticeDialogListener;

public class MainActivity extends ActionBarActivity implements NoticeDialogListener {
	
	private ListView drawerList;
	private DrawerLayout drawerLayout;
	private String[] drawerOptions;
	private ActionBarDrawerToggle drawerToggle;
	private Fragment[] fragments = new Fragment[] {
		new ViewPagerImageFragment(),
		new ListStoreFragment(),
		new ComunityFragment()
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		drawerList = (ListView) findViewById(R.id.leftDrawer);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        drawerOptions = getResources().getStringArray(R.array.drawer_options);
        
        drawerList.setAdapter(new ArrayAdapter<String> (this, R.layout.drawer_list_item, drawerOptions));
        
        drawerList.setItemChecked(0, true);
        drawerList.setOnItemClickListener(new DrawerItemClickListener());
        
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.drawable.ic_drawer, R.string.drawer_open, R.string.drawer_close) {
        	
        	public void onDrawerClosed(View view) {
        		ActivityCompat.invalidateOptionsMenu(MainActivity.this);
        	}
        	
        	public void onDrawerOpened(View drawerView) {
        		ActivityCompat.invalidateOptionsMenu(MainActivity.this);
        	}
        };
        
        drawerLayout.setDrawerListener(drawerToggle);
        
        ActionBar actionBar = getSupportActionBar();
		actionBar.setTitle(drawerOptions[0]);
        
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeButtonEnabled(true);
        
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction()
        	   .add(R.id.contentFrame, fragments[0])
        	   .add(R.id.contentFrame, fragments[1])
        	   .add(R.id.contentFrame, fragments[2])
        	   .hide(fragments[1])
        	   .hide(fragments[2])
        	   .commit();
	}
	
	public void setContent(int index) {
    	Fragment toHide = null;
    	Fragment toHide2 = null;
		Fragment toShow = null;
		ActionBar actionBar = getSupportActionBar();
		switch (index) {
			case 0:
				toShow = fragments[0];
				toHide = fragments[1];
				toHide2 = fragments[2];
				actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
				break;
			case 1:
				toHide = fragments[0];
				toShow = fragments[1];
				toHide2 = fragments[2];
				actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
				break;
			case 2:
				toHide = fragments[0];
				toHide2 = fragments[1];
				toShow = fragments[2];
				actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
				break;
		}
		
		actionBar.setTitle(drawerOptions[index]);
		
		FragmentManager manager = getSupportFragmentManager();
		manager.beginTransaction()
			   .hide(toHide)
			   .hide(toHide2)
			   .show(toShow)
			   .commit();
		
		drawerList.setItemChecked(index, true);
		drawerLayout.closeDrawer(drawerList);
    }
	
	@Override
    public void onConfigurationChanged(Configuration newConfig) {
    	super.onConfigurationChanged(newConfig);
    	drawerToggle.onConfigurationChanged(newConfig);
    }
    
    @Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		drawerToggle.syncState();
	}
    
    public boolean onOptionsItemSelected(MenuItem item) {
    	if (item.getItemId() == android.R.id.home) {
    		if (drawerLayout.isDrawerOpen(drawerList)) {
    			drawerLayout.closeDrawer(drawerList);
    		} else {
    			drawerLayout.openDrawer(drawerList);
    		}
    		return true;
    	}
    	return super.onOptionsItemSelected(item);
    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	class DrawerItemClickListener implements ListView.OnItemClickListener {

		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
			setContent(position);
		}
		
   }

	@Override
	public void onDialogPositiveClick() {
		// TODO Auto-generated method stub
		Intent intent = new Intent(getApplicationContext(), CameraActivity.class);
		startActivity(intent);
	}

	@Override
	public void onDialogNegativeClick() {
		// TODO Auto-generated method stub
		Toast.makeText(getApplicationContext(), "Hizo click en no :(", Toast.LENGTH_SHORT).show();
	}
}