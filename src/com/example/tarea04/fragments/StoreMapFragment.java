package com.example.tarea04.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

import com.example.tarea04.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnMapLongClickListener;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class StoreMapFragment extends SupportMapFragment implements OnMapLongClickListener {

	private GoogleMap map;
	private Bundle savedInstanceState;
	public static final LatLng GUATEMALA = new LatLng(14.62, -90.56);
	private RadioGroup mapOptions;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.savedInstanceState = savedInstanceState;
	}
	
	
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_store_map, null);
		
		mapOptions = (RadioGroup)view.findViewById(R.id.radioGroup1);
		OnCheckedChangeListener CheckedChangeListener = new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				switch (checkedId) {
					case R.id.radio0:
						map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
						break;
					case R.id.radio1:
						map.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
						break;
					case R.id.radio2:
						map.setMapType(GoogleMap.MAP_TYPE_HYBRID);
						break;
					case R.id.radio3:
						map.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
						break;
				}
			}
		};		
		mapOptions.setOnCheckedChangeListener(CheckedChangeListener);
		
		return view;
	}



	@Override
    public void onResume() {
        super.onResume();
        setupMap();
    }	
    
    public void setupMap() {
    	if (map == null) {
    		map = getMap();
            if (map != null) {
                if (savedInstanceState == null) {
                    map.moveCamera(CameraUpdateFactory.newLatLngZoom(GUATEMALA, 10));
                }

                map.getUiSettings().setZoomControlsEnabled(false);
            }
        }    	
    }



	@Override
	public void onMapLongClick(LatLng point) {
		LatLng pointTemp;
		MarkerOptions options;
		@SuppressWarnings("unused")
		Marker marker;
		
		pointTemp = new LatLng(point.latitude - 5, point.longitude - 5);
		options = new MarkerOptions().position(pointTemp).title("Lego Store").snippet("Tienda de Lego\nTercer nivel D-Mall\n2499-9760\n\nLun - Jue: 10:00 - 20:00\nVie - Sáb: 10:00 - 21:00\nDom: 10:00 - 19:00");
		marker = map.addMarker(options);
		
		pointTemp = new LatLng(point.latitude - 10, point.longitude - 10);
		options = new MarkerOptions().position(pointTemp).title("Artemis Edinter").snippet("Librerías Artemis Edinter con más de 33 años de experiencia en el mundo del libro.\nSegundo nivel D-Mall\n2336-6320\n\nLun - Jue: 10:00 - 20:00\nVie - Sáb: 10:00 - 21:00\nDom: 10:00 - 19:00");
		marker = map.addMarker(options);
		
		pointTemp = new LatLng(point.latitude + 10, point.longitude + 10);
		options = new MarkerOptions().position(pointTemp).title("McCafe").snippet("Bebidas calientes y frias así como diversas opciones de platillos dulces y salados.\nPrimer nivel D-Mall\n2385-5402\n\nLun - Jue: 10:00 - 20:00\nVie - Sáb: 10:00 - 21:00\nDom: 10:00 - 19:00");
		marker = map.addMarker(options);
		
		pointTemp = new LatLng(point.latitude + 5, point.longitude + 5);
		options = new MarkerOptions().position(pointTemp).title("Nine West").snippet("Calzado exclusivo para ti, siempre a la moda con estilos vanguardistas.\nPrimer nivel D-Mall\n2336-6889\n\nLun - Jue: 10:00 - 20:00\nVie - Sáb: 10:00 - 21:00\nDom: 10:00 - 19:00");
		marker = map.addMarker(options);

		pointTemp = new LatLng(point.latitude + 15, point.longitude - 10);
		options = new MarkerOptions().position(pointTemp).title("Bershka").snippet("Productos situados de acorde a tu estilo, desde formal hasta deportiva, y de prendas básicas a las de mayor tendencia.\nPrimer nivel D-Mall\n2336-6978\n\nLun - Jue: 10:00 - 20:00\nVie - Sáb: 10:00 - 21:00\nDom: 10:00 - 19:00");
		marker = map.addMarker(options);

		pointTemp = new LatLng(point.latitude -15, point.longitude + 10);
		options = new MarkerOptions().position(pointTemp).title("Aparicio").snippet("Venta de joyas y relojes.\nPrimer nivel D-Mall\n2336-6720\n\nLun - Jue: 10:00 - 20:00\nVie - Sáb: 10:00 - 21:00\nDom: 10:00 - 19:00");
		marker = map.addMarker(options);

		pointTemp = new LatLng(point.latitude - 15, point.longitude - 15);
		options = new MarkerOptions().position(pointTemp).title("Siman").snippet("Venta de ropa, accesorios, electrodomésticos y muebles.\nPrimer nivel D-Mall\n2444-7777\n\nLun - Jue: 10:00 - 20:00\nVie - Sáb: 10:00 - 21:00\nDom: 10:00 - 19:00");
		marker = map.addMarker(options);

		pointTemp = new LatLng(point.latitude + 15, point.longitude + 15);
		options = new MarkerOptions().position(pointTemp).title("Adoc").snippet("Esta es una de las zapaterías más grandes de Guatemala. Aquí podrá encontrar zapatos para toda la familia.\nSegundo nivel D-Mall\n2336-6883\n\nLun - Jue: 10:00 - 20:00\nVie - Sáb: 10:00 - 21:00\nDom: 10:00 - 19:00");
		marker = map.addMarker(options);

		pointTemp = new LatLng(point.latitude + 80, point.longitude + 40);
		options = new MarkerOptions().position(pointTemp).title("Max").snippet("Productos eléctricos y electrónicos para el entretenimiento y la comodidad en el hogar\nSegundo nivel D-Mall\n2336-6950\n\nLun - Jue: 10:00 - 20:00\nVie - Sáb: 10:00 - 21:00\nDom: 10:00 - 19:00");
		marker = map.addMarker(options);

		pointTemp = new LatLng(point.latitude + 40, point.longitude + 80);
		options = new MarkerOptions().position(pointTemp).title("BAM").snippet("Servicios Financieros.\nSegundo nivel D-Mall\n2338-6565\n\nLun - Jue: 10:00 - 20:00\nVie - Sáb: 10:00 - 21:00\nDom: 10:00 - 19:00");
		marker = map.addMarker(options);
	}
	
	
	
	
}
