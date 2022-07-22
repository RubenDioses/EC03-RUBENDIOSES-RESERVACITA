package com.idat.EC3RUBENDIOSESreservacita.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table(name = "Cliente")
@Entity
public class Cliente implements Serializable{	
	
	private static final long serialVersionUID = 8588424983065112238L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCliente;
	private String nombre;
	private String celular;
	
	@ManyToMany(mappedBy = "cliente", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<Hospital> hospital = new ArrayList<Hospital>();
	
	@OneToOne(mappedBy = "cliente")
	private UsuarioCliente usuariocliente;
	
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
