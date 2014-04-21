package com.example.tarea04.fragments;

import java.util.ArrayList;
import java.util.Arrays;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.tarea04.R;
import com.example.tarea04.activities.ImageViewActivity;
import com.example.tarea04.activities.InfoStoreActivity;

public class StoreListFragment extends Fragment implements OnItemClickListener {
	
	ListView list;
	String tienda = "";
	
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            
            String [] array_stores = getResources().getStringArray(R.array.array_stores);
			
            ArrayList<String> stores = new ArrayList<String>(Arrays.asList(array_stores));
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, stores);

            list.setAdapter(adapter);
            list.setOnItemClickListener(this);
            registerForContextMenu(list);
    }
    
    @Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_store_list, container, false);
	    list = (ListView)view.findViewById(R.id.listView);
		return view;
	}
    
    @Override
    public boolean onContextItemSelected(MenuItem item) {
            return onOptionsItemSelected(item);
    }
    
    
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        AdapterView.AdapterContextMenuInfo info =
                (AdapterView.AdapterContextMenuInfo) menuInfo;
        tienda = ((TextView) info.targetView).getText().toString();            
        
        MenuInflater inflater = getActivity().getMenuInflater();
        inflater.inflate(R.menu.list_store, menu);
    }
    
    @Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		// Inflate the menu; this adds items to the action bar if it is present.
		inflater.inflate(R.menu.list_store, menu);
	}
    
	@Override
	public void onItemClick(AdapterView<?> adapterView, View view, int position, long arg3) {
		tienda = adapterView.getItemAtPosition(position).toString();
		Intent intent = new Intent(getActivity(), InfoStoreActivity.class);
        intent.putExtra("name", tienda);
        startActivity(intent); 
		
	}
	
	@Override
    public boolean onOptionsItemSelected(MenuItem item) {
			Intent i;
            switch (item.getItemId()) {
                    case R.id.action_info:
                		i = new Intent(getActivity().getApplicationContext(),InfoStoreActivity.class);
                		i.putExtra("name", tienda);
                		startActivity(i);
                        return true;
                    case R.id.action_image:
                    	i = new Intent(getActivity().getApplicationContext(),ImageViewActivity.class);
                		i.putExtra("name", tienda);
                		startActivity(i);
                        return true;
                    default :
                        return super.onOptionsItemSelected(item);
            }                
    }
	
}

