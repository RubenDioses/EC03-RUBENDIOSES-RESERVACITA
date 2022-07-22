package com.idat.EC3RUBENDIOSESreservacita.model;

import java.io.Serializable;

public class UsuarioCliente implements Serializable {	
	
	private static final long serialVersionUID = -5628686548353061670L;
	
	private int idUsuario;
	private String usuario;
	private String password;
	private String rol;
	
	public UsuarioCliente() {
		super();
	}
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRol() {
		return rol;
	}
	public void setRol(String rol) {
		this.rol = rol;
	}
	
	

}
