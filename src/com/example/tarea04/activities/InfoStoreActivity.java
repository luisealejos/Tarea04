package com.example.tarea04.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar.Tab;
import android.support.v7.app.ActionBar.TabListener;
import android.support.v7.app.ActionBarActivity;
import android.text.util.Linkify;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tarea04.R;
import com.example.tarea04.pojo.Store;

public class InfoStoreActivity extends ActionBarActivity  implements TabListener {
	
	private String store = "";
    public final static String NAME = "name";
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.fragment_store_info);  

            Bundle b = this.getIntent().getExtras();                  
    		String txtName = b.getString(NAME);
    		store = txtName;
    		
    		Store temp = new Store();
    		temp.setNombre(txtName);
            if (txtName.equals("Lego Store")) {
            	temp.setDescripcion("Tienda de Lego");
            	temp.setDireccion("Tercer nivel D-Mall");
            	temp.setTelefono("2499-9760");
            	temp.setHorarios("Lun - Jue: 10:00 - 20:00\nVie - Sáb: 10:00 - 21:00\nDom: 10:00 - 19:00");
            	temp.setWebsite("https://es-la.facebook.com/legoguatemala");
            	temp.setEmail("info@legostore.com");
            	temp.setListado_comentarios("");
            	temp.setNumero_favoritos(0);
            	temp.setUbicacion_geografica("");
            } else if (txtName.equals("Artemis Edinter")) {
            	temp.setDescripcion("Librerías Artemis Edinter con más de 33 años de experiencia en el mundo del libro.");
            	temp.setDireccion("Segundo nivel D-Mall");
            	temp.setTelefono("2336-6320");
            	temp.setHorarios("Lun - Jue: 10:00 - 20:00\nVie - Sáb: 10:00 - 21:00\nDom: 10:00 - 19:00");
            	temp.setWebsite("http://www.artemisedinter.com/");
            	temp.setEmail("info@artemis.com.gt");
            	temp.setListado_comentarios("");
            	temp.setNumero_favoritos(0);
            	temp.setUbicacion_geografica("");
            } else if (txtName.equals("McCafe")) {
            	temp.setDescripcion("Bebidas calientes y frias así como diversas opciones de platillos dulces y salados.");
            	temp.setDireccion("Primer nivel D-Mall");
                temp.setTelefono("2385-5402");
                temp.setHorarios("Lun - Jue: 10:00 - 20:00\nVie - Sáb: 10:00 - 21:00\nDom: 10:00 - 19:00");
                temp.setWebsite("https://es-la.facebook.com/McCafeGuatemala");
                temp.setEmail("contact@mccafe.com");
				temp.setListado_comentarios("");
            	temp.setNumero_favoritos(0);
            	temp.setUbicacion_geografica("");
            } else if (txtName.equals("Nine West")) {
            	temp.setDescripcion("Calzado exclusivo para ti, siempre a la moda con estilos vanguardistas.");
            	temp.setDireccion("Primer nivel D-Mall");
                temp.setTelefono("2336-6889");
                temp.setHorarios("Lun - Jue: 10:00 - 20:00\nVie - Sáb: 10:00 - 21:00\nDom: 10:00 - 19:00");
                temp.setWebsite("http://www.ninewestca.com/");
                temp.setEmail("info@ninewestca.com");
				temp.setListado_comentarios("");
            	temp.setNumero_favoritos(0);
            	temp.setUbicacion_geografica("");
            } else if (txtName.equals("Bershka")) {
            	temp.setDescripcion("Productos situados de acorde a tu estilo, desde formal hasta deportiva, y de prendas básicas a las de mayor tendencia.");
            	temp.setDireccion("Primer nivel D-Mall");
                temp.setTelefono("2336-6978");
                temp.setHorarios("Lun - Jue: 10:00 - 20:00\nVie - Sáb: 10:00 - 21:00\nDom: 10:00 - 19:00");
                temp.setWebsite("http://www.bershka.com/");
                temp.setEmail("contact@bershka.com");
				temp.setListado_comentarios("");
            	temp.setNumero_favoritos(0);
            	temp.setUbicacion_geografica("");
            } else if (txtName.equals("Aparicio")) {
            	temp.setDescripcion("Venta de joyas y relojes.");
            	temp.setDireccion("Primer nivel D-Mall");
                temp.setTelefono("2336-6720");
                temp.setHorarios("Lun - Jue: 10:00 - 20:00\nVie - Sáb: 10:00 - 21:00\nDom: 10:00 - 19:00");
                temp.setWebsite("http://aparicio.com.gt/");
                temp.setEmail("servicio@aparicio.com.gt");
				temp.setListado_comentarios("");
            	temp.setNumero_favoritos(0);
            	temp.setUbicacion_geografica("");
            } else if (txtName.equals("Siman")) {
            	temp.setDescripcion("Venta de ropa, accesorios, electrodomésticos y muebles.");
            	temp.setDireccion("Primer nivel D-Mall");
                temp.setTelefono("2444-7777");
                temp.setHorarios("Lun - Jue: 10:00 - 20:00\nVie - Sáb: 10:00 - 21:00\nDom: 10:00 - 19:00");
                temp.setWebsite("http://www.siman.com/guatemala/");
                temp.setEmail("contacto@siman.com");
				temp.setListado_comentarios("");
            	temp.setNumero_favoritos(0);
            	temp.setUbicacion_geografica("");
            } else if (txtName.equals("Adoc")) {
            	temp.setDescripcion("Esta es una de las zapaterías más grandes de Guatemala. Aquí podrá encontrar zapatos para toda la familia.");
            	temp.setDireccion("Segundo nivel D-Mall");
                temp.setTelefono("2336-6883");
                temp.setHorarios("Lun - Jue: 10:00 - 20:00\nVie - Sáb: 10:00 - 21:00\nDom: 10:00 - 19:00");
                temp.setWebsite("https://es-la.facebook.com/adoccentroamerica");
                temp.setEmail("servicio@adoc.com.gt");
				temp.setListado_comentarios("");
            	temp.setNumero_favoritos(0);
            	temp.setUbicacion_geografica("");
            } else if (txtName.equals("Max")) {
            	temp.setDescripcion("Productos eléctricos y electrónicos para el entretenimiento y la comodidad en el hogar");
            	temp.setDireccion("Segundo nivel D-Mall");
                temp.setTelefono("2336-6950");
                temp.setHorarios("Lun - Jue: 10:00 - 20:00\nVie - Sáb: 10:00 - 21:00\nDom: 10:00 - 19:00");
                temp.setWebsite("http://www.max.com.gt/");
                temp.setEmail("RRHH@max.com.gt");
				temp.setListado_comentarios("");
            	temp.setNumero_favoritos(0);
            	temp.setUbicacion_geografica("");
            } else if (txtName.equals("BAM")) {
            	temp.setDescripcion("Servicios Financieros.");
            	temp.setDireccion("Segundo nivel D-Mall");
                temp.setTelefono("2338-6565");
                temp.setHorarios("Lun - Jue: 10:00 - 20:00\nVie - Sáb: 10:00 - 21:00\nDom: 10:00 - 19:00");
                temp.setWebsite("http://www.bam.com.gt/");
                temp.setEmail("bam@bam.com.gt");
				temp.setListado_comentarios("");
            	temp.setNumero_favoritos(0);
            	temp.setUbicacion_geografica("");
            } else {
            	temp.setNombre("");
            	temp.setDescripcion("");
            	temp.setDireccion("");
            	temp.setTelefono("");
            	temp.setHorarios("");
            	temp.setWebsite("");
            	temp.setEmail("");
            	temp.setListado_comentarios("");
            	temp.setNumero_favoritos(0);
            	temp.setUbicacion_geografica("");
            }
    		
            TextView txtDescription = (TextView)findViewById(R.id.txtDescription);
    		TextView txtNameStore = (TextView)findViewById(R.id.txtName); 
    		TextView txtAddress = (TextView)findViewById(R.id.txtAddress); 
    		TextView txtTelephone = (TextView)findViewById(R.id.txtTelephone); 
    		TextView txtHorario = (TextView)findViewById(R.id.txtHorario); 
    		TextView txtWebsite = (TextView)findViewById(R.id.txtWebsite); 
    		TextView txtEmail = (TextView)findViewById(R.id.txtEmail); 
    		
    		txtDescription.setText(temp.getDescripcion());
    		txtNameStore.setText(temp.getNombre());
    		txtAddress.setText(temp.getDireccion());
    		txtTelephone.setText("Telefono: " + temp.getTelefono());
    		txtHorario.setText(temp.getHorarios());
    		txtWebsite.setText("Web: " + temp.getWebsite());
    		txtEmail.setText("Contacto: " + temp.getEmail());
    		
    		//Linkify.addLinks(txtDescription1, Linkify.ALL);
    		//Linkify.addLinks(txtName1, Linkify.ALL);
    		Linkify.addLinks(txtAddress, Linkify.MAP_ADDRESSES);
    		Linkify.addLinks(txtTelephone, Linkify.PHONE_NUMBERS);
    		//Linkify.addLinks(txtHorario1, Linkify.ALL);
    		Linkify.addLinks(txtWebsite, Linkify.WEB_URLS);
    		Linkify.addLinks(txtEmail, Linkify.EMAIL_ADDRESSES);
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
            getMenuInflater().inflate(R.menu.info_store, menu);                
            return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	Intent i;
        switch (item.getItemId()) {
	        case R.id.action_image:                                
	        	i = new Intent(getApplicationContext(),ImageViewActivity.class);
        		i.putExtra("name", store);
        		startActivity(i);
	        	return true;
	        case R.id.action_list:
	        	i = new Intent(getApplicationContext(),MainActivity.class);
        		i.putExtra("name", store);
        		startActivity(i);
                return true;
	        case R.id.action_favorite:
	        	Toast.makeText(getApplicationContext(), "Favorito", Toast.LENGTH_SHORT).show();
	        	return true;
	        case R.id.action_share:
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_SEND);                                        
                intent.putExtra(Intent.EXTRA_TEXT, getResources().getText(R.string.msg_share) + " " + store + "!\n Visitalo en D-Mall.");
                intent.setType("text/plain");
                startActivity(Intent.createChooser(intent, getResources().getText(R.string.action_share)));
	        	return true;
	        default :
               return super.onOptionsItemSelected(item);
        }                
    }
    
    public String getStoreSelected(){
    	return store;
    }

	@Override
	public void onTabReselected(Tab arg0, FragmentTransaction arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTabSelected(Tab arg0, FragmentTransaction arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTabUnselected(Tab arg0, FragmentTransaction arg1) {
		// TODO Auto-generated method stub
		
	}
    
}
