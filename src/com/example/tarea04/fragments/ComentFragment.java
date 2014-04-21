package com.example.tarea04.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.tarea04.R;
import com.example.tarea04.pojo.Comment;
import com.example.tarea04.pojo.Photo;

public class ComentFragment extends Fragment {

	EditText editComment;
	TextView txtComment;
	Button buttonComment;

	Comment comentario;
	Photo descripcion_foto;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_comment, container, false);
		editComment = (EditText)view.findViewById(R.id.editComment);
		txtComment = (TextView)view.findViewById(R.id.txtComment);
		buttonComment = (Button)view.findViewById(R.id.buttonComment);
		return view;
	}
	
	@Override
    public void onActivityCreated(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		buttonComment.setOnClickListener(new OnClickListener() {	
    		public void onClick(View v) {
    			String comm = "- " + editComment.getText().toString();
    			comentario.setComentario(comm);
    			descripcion_foto.addListado_comentario(comentario);
    			txtComment.setText(setTextView(descripcion_foto));
    			editComment.setText("");
    		}
    	});
    }
	
	public String setTextView(Photo com) {
		String text = "";
		int size = com.getlenght_comentario();
		for (int i = 0; i > size; i++) {
			text = text + com.get_comentario(i).getComentario();
		}
		return text;
	}
}
