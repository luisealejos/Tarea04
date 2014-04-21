package com.example.tarea04.activities;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.tarea04.R;
import com.example.tarea04.pojo.Photo;

public class ImageViewActivity extends ActionBarActivity {
	ImageView imageView;
	String tienda = "";
	Photo fotografia = new Photo();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_image_view);
		
		imageView = (ImageView)findViewById(R.id.ImageView);
		
		Bundle b = this.getIntent().getExtras();                  
		fotografia.setDescripcion(b.getString("name"));
		Drawable drawable = null;
		Resources res = getResources();
		
		String txtName = fotografia.getDescripcion();
		if (txtName.equals("Lego Store")) {
			drawable = res.getDrawable(R.drawable.lego_store);
        } else if (txtName.equals("Artemis Edinter")) {
        	fotografia.setURL("artemis");
        	drawable = res.getDrawable(R.drawable.artemis);
        } else if (txtName.equals("McCafe")) {
        	fotografia.setURL("mc_cafe");
        	drawable = res.getDrawable(R.drawable.mc_cafe);
        } else if (txtName.equals("Siman")) {
        	fotografia.setURL("siman");
        	drawable = res.getDrawable(R.drawable.siman);
        } else if (txtName.equals("Nine West")) {
        	fotografia.setURL("ninewest");
        	drawable = res.getDrawable(R.drawable.ninewest);
        } else if (txtName.equals("Bershka")) {
        	fotografia.setURL("bershka");
        	drawable = res.getDrawable(R.drawable.bershka);
        } else if (txtName.equals("Aparicio")) {
        	fotografia.setURL("aparicio");
        	drawable = res.getDrawable(R.drawable.aparicio);
        } else if (txtName.equals("Adoc")) {
        	fotografia.setURL("adoc");
        	drawable = res.getDrawable(R.drawable.adoc);
        } else if (txtName.equals("Max")) {
        	fotografia.setURL("max");
        	drawable = res.getDrawable(R.drawable.max);
        } else if (txtName.equals("BAM")) {
        	fotografia.setURL("bam");
        	drawable = res.getDrawable(R.drawable.bam);
        }
		
		imageView.setImageDrawable(drawable);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.image_view, menu);
		return true;
	}
	
	@Override
    public boolean onOptionsItemSelected(MenuItem item) {
			Intent i;
            switch (item.getItemId()) {
		            case R.id.action_list:
		        		i = new Intent(getApplicationContext(),MainActivity.class);
		        		startActivity(i);
		                return true;
                    case R.id.action_info:
                    		i = new Intent(getApplicationContext(),InfoStoreActivity.class);
                    		i.putExtra("name", fotografia.getDescripcion());
                    		startActivity(i);
                            return true;
                    case R.id.action_favorite:
        	        	Toast.makeText(getApplicationContext(), "Favorito", Toast.LENGTH_SHORT).show();
        	        	return true;
        	        case R.id.action_share:
        	        	/*
	        	        	Using Resource Name
		        	        	Syntax : android.resource://[package]/[res type]/[res name]
		        	        	Example : Uri.parse("android.resource://com.segf4ult.test/drawable/icon");
	
	        	        	Using Resource Id
		        	        	Syntax : android.resource://[package]/[resource_id]
		        	        	Example : Uri.parse("android.resource://com.segf4ult.test/" + R.drawable.icon);
		        	        	
		        	        Intent shareIntent = new Intent();
							shareIntent.setAction(Intent.ACTION_SEND);
							shareIntent.putExtra(Intent.EXTRA_STREAM, uriToImage);
							shareIntent.setType("image/jpeg");
							startActivity(Intent.createChooser(shareIntent, getResources().getText(R.string.send_to)));
        	        	*/
        	        	//Uri path = Uri.parse("android.resource://com.example.tarea02/res/drawable-mdpi/max.png");
        	        	//Uri path = Uri.parse("android.resource://com.example.tarea02/"+R.drawable.lego_store);
        	        	//Uri path = Uri.parse("android.resource://com.example.tarea02/drawable/" + image);
        	        	//Uri path = Uri.parse("android.resource://" + this.getPackageName() + "/drawable/" + image);
        	        	//Uri path = Uri.parse("android.resource://" + this.getPackageName() + "/res/drawable-mdpi/" + image + ".png");
        	        	//Uri path = Uri.parse("android.resource://com.example.tarea02/drawable/" + image + ".png");
        	        	
        	        	Uri path = Uri.parse("android.resource//" + this.getPackageName() + "/drawable/" + fotografia.getURL());
        	        	Intent shareIntent = new Intent();
        	        	shareIntent.setAction(Intent.ACTION_SEND);
        	        	shareIntent.putExtra(Intent.EXTRA_STREAM, path);
        	        	shareIntent.setType("image/png");
        	        	startActivity(Intent.createChooser(shareIntent, fotografia.getDescripcion()));
        	        	return true;
                    default :
                            return super.onOptionsItemSelected(item);
            }                
    }
}
