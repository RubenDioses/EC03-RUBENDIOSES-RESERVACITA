package com.idat.EC3RUBENDIOSESreservacita.model;

import java.io.Serializable;

public class Cliente implements Serializable{
	
	
	private static final long serialVersionUID = 8588424983065112238L;
	
	private int idCliente;
	private String nombre;
	private String celular;
	
	
	public Cliente() {
		super();
	}
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	
	

}
