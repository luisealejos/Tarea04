package com.example.tarea04.pojo;

public class Photo {
	
	String URL;
	String Descripcion;
	Comment[] Listado_comentarios;
	int Numero_favoritos;
	
	public String getURL() {
		return URL;
	}
	public void setURL(String uRL) {
		URL = uRL;
	}
	public String getDescripcion() {
		return Descripcion;
	}
	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}
	public Comment[] getListado_comentarios() {
		return Listado_comentarios;
	}
	public void setListado_comentarios(Comment[] listado_comentarios) {
		Listado_comentarios = listado_comentarios;
	}
	public void addListado_comentario(Comment listado_comentario) {
		int i = Listado_comentarios.length;
		Listado_comentarios[i-1] = listado_comentario;
	}
	public int getlenght_comentario() {
		return Listado_comentarios.length;
	}
	public Comment get_comentario(int i) {
		return Listado_comentarios[i];
	}
	public int getNumero_favoritos() {
		return Numero_favoritos;
	}
	public void setNumero_favoritos(int numero_favoritos) {
		Numero_favoritos = numero_favoritos;
	}
	
	

}
